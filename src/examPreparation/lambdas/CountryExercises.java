package examPreparation.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryExercises {
	static List<Country> countries = new ArrayList<>(Arrays.asList(new Country("Schweiz", 41285),
			new Country("Germany", 357021), new Country("France", 675417), new Country("Italy", 301230),
			new Country("Austria", 83858), new Country("Russia", 17098246), new Country("Luxembourg", 2586),
			new Country("Liechtenstein", 160), new Country("United Kingdom", 244820)));

	public static void main(String[] args) {
		System.out.println("\n\nExercise 1\n");
		example1();

		Collections.shuffle(countries);
		System.out.println("\n\nExercise 2\n");
		example2();

		Collections.shuffle(countries);
		System.out.println("\n\nExercise 3\n");
		example3();

		Collections.shuffle(countries);
		System.out.println("\n\nExercise 4\n");
		example4();

		Collections.shuffle(countries);
		System.out.println("\n\nExercise 5\n");
		example5();
	}
	//Sort countries by name, using List.sort, Comparator.comparing and a
	//lambda. Then print them using a lambda
	public static void example1() {
		countries.sort(Comparator.comparing(c -> c.getName()));
		countries.forEach(c -> System.out.println(c));
	}
	//same, only with method references
	public static void example2() {
		countries.sort(Comparator.comparing(Country::getName));
		countries.forEach(System.out::println);
	}
	//Print all countries that have an area < 100000.
	public static void example3() {
		countries.forEach(c -> {
			if(c.getArea() < 100000)
				System.out.println(c);
		});
	}
	//Sort the countries using their natural order (class implements Comparable<Country>)
	public static void example4() {
		countries.sort(Comparator.naturalOrder());
	}
	//Replace all countries in the list with new countries, where the name includes the two-letter abbreviation.
	//Take the first two letters of the country name as the abbreviation. For example, "Germany" becomes "GE: Germany".
	//Sort the new countries by the first two letters (by the abbreviations)
	public static void example5() {
		countries.replaceAll(c -> new Country(c.getName().substring(0, 2).toUpperCase()+" : "+c.getName(), c.getArea()));
		countries.sort(Comparator.comparing(c -> c.getName().substring(0, 2)));
	}
}
