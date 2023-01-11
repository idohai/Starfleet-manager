import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        this.basicAnnualMaintenance = 4000;
        this.engineMaintenanceFactor = 500;
        this.crewMaintenance = 500;
	}

    @Override
    public String toString(){
        String value = "ColonialViper" + super.toString().substring(7);
        return value;
    }
}
