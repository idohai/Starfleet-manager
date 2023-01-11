public class Cylon extends AbstractCrewMember {

    private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
        super(age, yearsInService, name);
        this.modelNumber = modelNumber;		
	}
	
    public int getModelNumber(){
        return this.modelNumber;
    }

}
