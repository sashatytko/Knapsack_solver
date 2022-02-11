import org.javatuples.Pair;

import java.util.List;

public class Lab1 {
	public static void main(String[] args) {

		int bagCapacity = 29;

		System.out.println("Bag capacity = " + bagCapacity);

		List<Item> itemList = List.of(
				Item.builder().name("Ring").value(2000d).weight(3).build(),
				Item.builder().name("Laptop").value(600d).weight(6).build(),
				Item.builder().name("1").value(500d).weight(10).build(),
				Item.builder().name("2").value(870d).weight(12).build(),
				Item.builder().name("3").value(920d).weight(9).build(),
				Item.builder().name("4").value(1100d).weight(12).build()
		);

		Pair<List<Item>, Double> solution = KnapsackSolver.solve(itemList, bagCapacity);

		System.out.println("\nMaximum value:\t" + solution.getValue1() + "\n");
		System.out.println("Item list:");
		solution.getValue0().stream().forEach(i -> System.out.println(i.getName() + "\t\t\t" + i.getValue() + "\t\t\t" + i.getWeight()));
	}


}
