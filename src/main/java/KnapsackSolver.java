import org.javatuples.Pair;
import org.javatuples.Quartet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackSolver {

	public static Pair<List<Item>, Double> solve(List<Item> itemList, int maxWeight) {

		int itemListSize = itemList.size();

		if (itemListSize <= 0 || maxWeight <= 0) {
			return Pair.with(Collections.emptyList(), 0d);
		}

		List<Item> itemsToTake = new ArrayList<>();

		double[][] m = new double[itemListSize + 1][maxWeight + 1];
		Quartet<Item, Integer, Integer, Boolean>[][] items = new Quartet[itemListSize + 1][maxWeight + 1];

		for (int j = 0; j <= maxWeight; j++) {
			m[0][j] = 0;
		}

		for (int i = 1; i <= itemListSize; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				Item currentItem = itemList.get(i - 1);
				if (currentItem.getWeight() > j) {
					m[i][j] = m[i - 1][j];
					items[i][j] = Quartet.with(currentItem, i - 1, j, true);
				} else {
					int remainWeight = j - currentItem.getWeight();
					double withCurrentValue = m[i - 1][remainWeight] + currentItem.getValue();
					double previousValue = m[i - 1][j];
					if (withCurrentValue > previousValue) {
						if (withCurrentValue == currentItem.getValue()) {
							items[i][j] = Quartet.with(currentItem, null, null, false);
						} else {
							items[i][j] = Quartet.with(currentItem, i - 1, remainWeight, false);
						}
					} else {
						items[i][j] = Quartet.with(currentItem, i - 1, j, true);
					}
					m[i][j] = Math.max(withCurrentValue, previousValue);
				}
			}
		}
		return Pair.with(getItems(items, itemsToTake, itemListSize, maxWeight), m[itemListSize][maxWeight]);
	}

	private static List<Item> getItems(Quartet<Item, Integer, Integer, Boolean>[][] items, List<Item> itemList, Integer i, Integer j) {
		if (i == null || j == null) {
			return itemList;
		}
		if (!items[i][j].getValue3()) {
			itemList.add(items[i][j].getValue0());
		}
		return getItems(items, itemList, items[i][j].getValue1(), items[i][j].getValue2());
	}

}
