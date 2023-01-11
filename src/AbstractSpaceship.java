import java.util.Objects;
import java.util.Set;

public abstract class AbstractSpaceship implements Spaceship{

    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected int firePower;
    protected Set<? extends CrewMember> crewMembers;


    public AbstractSpaceship (String name, int commissionYear, float maximalSpeed, int firePower, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.firePower = firePower;
        this.crewMembers = crewMembers;
    }

    public String getName(){
        return this.name;
    }

    public int getCommissionYear(){
        return this.commissionYear;
    }

    public float getMaximalSpeed(){
        return this.maximalSpeed;
    }

    public int getFirePower(){
        return this.firePower;
    }

    public Set<? extends CrewMember> getCrewMembers(){
        return this.crewMembers;
    }
    
    public abstract int getAnnualMaintenanceCost();
    
    @Override
    public String toString(){
        String value = "\n\tName=" + name + 
        "\n\tCommissionYear=" + commissionYear +
        "\n\tMaximalSpeed=" + maximalSpeed +
        "\n\tFirePower=" + firePower +
        "\n\tCrewMembers=" + crewMembers.size() +
        "\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost();
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSpaceship that = (AbstractSpaceship) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}