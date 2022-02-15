import org.javatuples.Pair;

import java.util.List;

public class Lab1 {
	public static void main(String[] args) {

		int bagCapacity = 29;

		System.out.println("Bag capacity = " + bagCapacity);

		List<Item> itemList = List.of(
				Item.builder().name("Item 1").value(2000d).weight(3).build(),
				Item.builder().name("Item 2").value(600d).weight(6).build(),
				Item.builder().name("Item 3").value(500d).weight(10).build(),
				Item.builder().name("Item 4").value(921d).weight(10).build(),
				Item.builder().name("Item 5").value(920d).weight(9).build(),
				Item.builder().name("Item 6").value(1100d).weight(12).build()
		);

		Pair<List<Item>, Double> solution = KnapsackSolver.solve(itemList, bagCapacity);

		System.out.println("\nMaximum value: " + solution.getValue1() + "\n");
		System.out.println("Item list:");
		solution.getValue0().forEach(System.out::println);
	}


}
