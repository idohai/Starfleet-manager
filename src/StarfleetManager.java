import java.util.*;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<String> sortedList = new LinkedList<>();
		fleet.stream()
				.sorted(Comparator.comparing(Spaceship::getFirePower)
				.thenComparing(Spaceship::getCommissionYear)
				.thenComparing(comparing(Spaceship::getName).reversed()))
				.map(x-> {String str = x.toString(); return str;})
				.forEach(str -> sortedList.add(0, str));
		return sortedList;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> shipTypesCount = new HashMap<>();
		int tempClassCount = 0;
		for (Spaceship spaceship : fleet){
			String currentClass = spaceship.getClass().getSimpleName();
			tempClassCount = shipTypesCount.getOrDefault(currentClass, 0);
			tempClassCount += 1;
			shipTypesCount.put(currentClass, tempClassCount);
		}
		return shipTypesCount;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalAnnualMaintenanceCost = 0;
		for (Spaceship spaceship : fleet){
			totalAnnualMaintenanceCost += spaceship.getAnnualMaintenanceCost();
		}
		return totalAnnualMaintenanceCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponsSet = new HashSet<>();
		for (Spaceship spaceship : fleet){
			if (spaceship instanceof AbstractBattleship){
				for (Weapon weapon : ((AbstractBattleship) spaceship).getWeapon()){
					weaponsSet.add(weapon.getName());
				}
			}
		}
		return weaponsSet;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int crewCnt = 0;
		for (Spaceship spaceship : fleet){
			crewCnt += spaceship.getCrewMembers().size();
		}
		return crewCnt;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float officersCnt = 0;
		float officersAgeSum = 0;
		for (Spaceship spaceship : fleet){
			for (CrewMember cm : spaceship.getCrewMembers()){
				if (cm instanceof Officer){
					officersCnt += 1;
					officersAgeSum += cm.getAge();
				}
			}
		}
		return (officersAgeSum / officersCnt);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> shipCaptainMap = new HashMap<>();
		OfficerRank tempRank = OfficerRank.Lieutenant;
		Officer tempOfficer = null;
		boolean officerFlag = false;
		for (Spaceship spaceship : fleet){
			for (CrewMember cm : spaceship.getCrewMembers()){
				if (cm instanceof Officer){
					if (((Officer) cm).getRank().compareTo(tempRank) >= 0){
						tempOfficer = (Officer) cm;
						tempRank = tempOfficer.getRank();
						officerFlag = true;
					}
				}
			}
			if (officerFlag){
				shipCaptainMap.put(tempOfficer, spaceship);
				officerFlag = false;
			}
			tempRank = OfficerRank.Lieutenant;
		}
		return shipCaptainMap;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> officersRankMap = new HashMap<>();
		for (Spaceship spaceship : fleet){
			for (CrewMember cm : spaceship.getCrewMembers()){
				if (cm instanceof Officer){
					OfficerRank rank = ((Officer)cm).getRank();
					Integer value = officersRankMap.getOrDefault(rank, 0);
					value += 1;
					officersRankMap.put(rank, value);
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> sortedOfficersRank = new ArrayList<>(officersRankMap.entrySet());
		Comparator<Map.Entry<OfficerRank, Integer>> cmp = (x, y)-> {
			int value = Integer.compare(x.getValue(), y.getValue());
			if (value == 0){
				value = x.getKey().compareTo(y.getKey());
			}
			return value;
		};
		Collections.sort(sortedOfficersRank, cmp);
		return sortedOfficersRank;
	}

}
