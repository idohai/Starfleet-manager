import java.util.Objects;

public abstract class AbstractCrewMember implements CrewMember{

protected int age;
protected int yearsInService;
protected String name;

    public AbstractCrewMember(int age, int yearsInService, String name){
        this.age = age;
        this.yearsInService = yearsInService;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getYearsInService(){
        return this.yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCrewMember that = (AbstractCrewMember) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}