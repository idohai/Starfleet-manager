import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class SpaceShipDetails implements Spaceship {

    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected int firePower;
    protected Set<? extends CrewMember> crewMembers;
    protected int annualMaintenanceCost;
    public static int numOfCloakingDevice;
    protected List<Weapon> Weapon;


    public SpaceShipDetails(String name, int commissionYear, float maximalSpeed, int firePower, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.firePower = firePower + 10;
        this.crewMembers = crewMembers;
    }

    public String getName() {
        return this.name;
    }

    public int getCommissionYear() {
        return this.commissionYear;
    }

    public float getMaximalSpeed() {
        return this.maximalSpeed;
    }

    public int getFirePower(){
        return this.firePower;

    }

    public Set<? extends CrewMember> getCrewMembers(){
        return this.crewMembers;
    }

    public int getAnnualMaintenanceCost(){
        return this.annualMaintenanceCost;
    }

    public List<Weapon> getWeapon(){
        return this.Weapon;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceShipDetails)) return false;
        SpaceShipDetails that = (SpaceShipDetails) o;
        return getCommissionYear() == that.getCommissionYear() &&
                Float.compare(that.getMaximalSpeed(), getMaximalSpeed()) == 0 &&
                getFirePower() == that.getFirePower() &&
                getAnnualMaintenanceCost() == that.getAnnualMaintenanceCost() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCrewMembers(), that.getCrewMembers()) &&
                Objects.equals(getWeapon(), that.getWeapon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCommissionYear(), getMaximalSpeed(), getFirePower(), getCrewMembers(), getAnnualMaintenanceCost(), getWeapon());
    }

    @Override
    public String toString() {
        String str =this.getClass().getSimpleName() + System.lineSeparator()+
                "\tName="+this.getName()+System.lineSeparator() +
                "\tCommissionYear="+this.getCommissionYear()+System.lineSeparator() +
                "\tMaximalSpeed="+this.getMaximalSpeed()+ System.lineSeparator() +
                "\tFirePower=" +this.getFirePower()+System.lineSeparator()+
                "\tCrewMembers="+this.crewMembers.size()+System.lineSeparator()+
                "\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost();
        return str;
    }

}
