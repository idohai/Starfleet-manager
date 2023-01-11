import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

    private static int stealthEngineCount = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        stealthEngineCount += 1;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
        this(name, commissionYear, maximalSpeed, crewMembers, defaultWeapon());
	}

    //@Override
    public int getAnnualMaintenanceCost(){
        int annualCost = super.getAnnualMaintenanceCost();
        annualCost += (stealthEngineCount * 50);
        return annualCost;
    }

    @Override
    public String toString(){
        String value = "StealthCruiser" + super.toString().substring(7);
        return value;
    }
    
    private static List<Weapon> defaultWeapon(){
        List<Weapon> weaponList = new LinkedList<>();
        weaponList.add(new Weapon ("Laser Cannons", 10, 100));
        return weaponList;
    }
}
