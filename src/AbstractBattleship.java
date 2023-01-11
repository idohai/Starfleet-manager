import java.util.List;
import java.util.Set;

public abstract class AbstractBattleship extends AbstractSpaceship{
    protected List<Weapon> weapons;
    protected int basicAnnualMaintenance;
    protected int engineMaintenanceFactor;
    protected int crewMaintenance;
    private int annualMaintenanceCost = -1;

    public AbstractBattleship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, calcFirePower(weapons), crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapon(){
        return this.weapons;
    }
    
    public int getAnnualMaintenanceCost(){
        if (this.annualMaintenanceCost == -1){
            int annualCost = this.basicAnnualMaintenance;
            annualCost += getFirePowerCost();
            annualCost += Math.round(this.engineMaintenanceFactor * maximalSpeed);
            annualCost += this.crewMaintenance * crewMembers.size();
            this.annualMaintenanceCost = annualCost;
            return annualCost;
        }
        else{
            return this.annualMaintenanceCost;
        }
    }

    public String toString(){
        String value = super.toString() + "\n\tWeaponArray=" + this.weapons.toString();
        return value;
    }
    
    private static int calcFirePower(List<Weapon> weapons){
        int firePower = 10;
        for (Weapon weapon : weapons){
            firePower += weapon.getFirePower();
        }
        return firePower;
    }

    protected int getFirePowerCost(){
        int firePowerCost = 0;
        for (Weapon weapon : this.weapons){
            firePowerCost += weapon.getAnnualMaintenanceCost();
        }
        return firePowerCost;
    }
}