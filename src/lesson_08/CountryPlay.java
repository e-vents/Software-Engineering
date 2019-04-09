package lesson_08;

import java.util.ArrayList;
import java.util.Collections;

public class CountryPlay {

	public static void main(String[] args) {
		
		ArrayList<Country> countries = new ArrayList<>();
		countries.add(new Country("switzerland", 41285, 8526932));
		countries.add(new Country("germany", 357021, 82887000));
		countries.add(new Country("france", 675417, 67372000));
		countries.add(new Country("austria", 83858, 8857960));
		//gives an anonymous comparator-obejct
		Collections.sort(countries, (d1, d2) -> Integer.compare(d1.getPopulation(), d2.getPopulation()));
		//same as
		Collections.sort(countries, (d1, d2) -> (d1.getPopulation() - d2.getPopulation()));
		//same as
		countries.sort((d1, d2) -> (d1.getPopulation() - d2.getPopulation()));
		
		for(Country c : countries)
			System.out.println(c); 
	}
}
