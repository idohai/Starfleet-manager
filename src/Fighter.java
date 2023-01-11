import java.util.List;
import java.util.Set;

public class Fighter extends AbstractBattleship {

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super (name, commissionYear, maximalSpeed, crewMembers, weapons);
        this.basicAnnualMaintenance = 2500;
        this.engineMaintenanceFactor = 1000;
        this.crewMaintenance = 0;
    }

    @Override
    public String toString(){
        String value = "Fighter" + super.toString();
        return value;
    }
}
