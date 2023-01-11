import java.util.Objects;

public abstract class PersonalDetails implements CrewMember {

    protected String Name;
    protected int Age;
    protected int YearsInService;

    public PersonalDetails(int age, int yearsInService, String name) {
        this.Name = name;
        this.Age = age;
        this.YearsInService = yearsInService;
    }

    public String getName() {
        return this.Name;
    }

    public int getAge() {
        return this.Age;
    }

    public int getYearsInService() {
        return this.YearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalDetails)) return false;
        PersonalDetails that = (PersonalDetails) o;
        return getAge() == that.getAge() &&
                getYearsInService() == that.getYearsInService() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getYearsInService());
    }

    public String toString() {
        String str = this.getClass().getSimpleName() + System.lineSeparator()+
                "\tName=" + this.getName() + System.lineSeparator() +
                "\tAge=" + this.getAge() + System.lineSeparator() +
                "\tYearsInService=" + this.getYearsInService();
        return str;
    }
}
