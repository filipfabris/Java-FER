package zadatak5;

import java.util.Arrays;
import static java.util.Map.entry;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Examples {

	public static void main(String[] args) {
		
		List<Integer> zlatkovaPlacaZa2017 = Arrays.asList(4600, 4500, 4700, 4650, 5000, 3800, 1700, 6000, 3200, 1400, 5100, 800);
		List<Integer> marijinaPlacaZa2017 = Arrays.asList(5600, 3500, 5700, 4950, 5100, 4100, 1800, 5800, 3250, 1490, 4800, 600);
		List<Integer> patricijinaPlacaZa2017 = Arrays.asList(3800, 4800, 4100, 4350, 4870, 3800, 1900, 4950, 3600, 1600, 4300, 900);
		List<Integer> antinaPlacaZa2017 = Arrays.asList(3000, 1700, 2500, 1050, 3200, 1200, 1500, 4000, 1400, 1700, 3000, 300);
		
		
		List<Integer> zlatkovaPlacaZa2018 = Arrays.asList(300, 1780, 2600, 1250, 3300, 1100, 1600, 4300, 1500, 1300, 2500, 400);
		List<Integer> marijinaPlacaZa2018 = Arrays.asList(1500, 2000, 3000, 4650, 2300, 2500, 1700, 1300, 1050, 1560, 1200, 700);
		List<Integer> patricijinaPlacaZa2018 = Arrays.asList(4200, 4100, 4600, 1350, 3870, 3900, 2000, 2750, 8000, 4000, 4200, 100);
		List<Integer> antinaPlacaZa2018 = Arrays.asList(4000, 4000, 4500, 4900, 5100, 4400, 1600, 4000, 3600, 2000, 3800, 900);
		
		
				
		Map<Integer, List<Integer>> placePoGodiniZLATKO = Map.ofEntries(
				entry(2017, zlatkovaPlacaZa2017),
				entry(2018, zlatkovaPlacaZa2018)
				);
		
		Map<Integer, List<Integer>> placePoGodiniMARIJA = Map.ofEntries(
				entry(2017, marijinaPlacaZa2017),
				entry(2018, marijinaPlacaZa2018)
				);
		
		Map<Integer, List<Integer>> placePoGodiniPATRICIJA = Map.ofEntries(
				entry(2017, patricijinaPlacaZa2017),
				entry(2018, patricijinaPlacaZa2018)
				);
		
		Map<Integer, List<Integer>> placePoGodiniANTE = Map.ofEntries(
				entry(2017, antinaPlacaZa2017),
				entry(2018, antinaPlacaZa2018)
				);
		
		//Za identifikator cu koristiti imena, cisto radi jednostavnosti
		
		Map<String, Map<Integer, List<Integer>>> zaProcesiranje = Map.ofEntries(
				entry("Zlatko", placePoGodiniZLATKO),
				entry("Marija", placePoGodiniMARIJA),
				entry("Patricija", placePoGodiniPATRICIJA),
				entry("Ante", placePoGodiniANTE)
				);
		
		Map<Integer, Set<String>> result = LabTask.underpayed(zaProcesiranje);
		
		for(Integer year : result.keySet()) {
			System.out.println("GODINA " + year + ":");
			for(String name : result.get(year))
				System.out.println(name);
		}
	}
}
