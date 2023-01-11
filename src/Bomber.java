import java.util.List;
import java.util.Set;

public class Bomber extends AbstractBattleship{
    
    private int numOfTech;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
	   super(name, commissionYear, maximalSpeed, crewMembers, weapons);
       this.numOfTech = numberOfTechnicians;
       this.basicAnnualMaintenance = 5000;
	}

    public int getNumberOfTechnicians(){
        return this.numOfTech;
    }

    @Override
    public int getAnnualMaintenanceCost(){
        int annualCost = this.basicAnnualMaintenance;
        float discount = (float) numOfTech / 10;
        annualCost += Math.round(this.getFirePowerCost() * (discount));
        return annualCost;
    }

    @Override
    public String toString(){
        String value = "Bomber" + super.toString() +
        "\n\tNumberOfTechnicians=" + numOfTech;
        return value;
    }
}
