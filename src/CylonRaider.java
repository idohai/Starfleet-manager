import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,	List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        this.basicAnnualMaintenance = 3500;
        this.engineMaintenanceFactor = 1200;
        this.crewMaintenance = 500;
	}

    @Override
    public String toString(){
        String value = "CylonRaider" + super.toString().substring(7);
        return value;
    }
}
