import java.util.Set;

public class TransportShip extends AbstractSpaceship{

    private int basicAnnualMaintenance = 3000;
	private int cargoCapacity;
    private int passengerCapacity;
    private int annualMaintenanceCost = -1;


	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
        super(name, commissionYear, maximalSpeed, 10, crewMembers );
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
	}

    public int getAnnualMaintenanceCost(){
        if (this.annualMaintenanceCost == -1){
            int annualCost = this.basicAnnualMaintenance;
            annualCost += 5*this.cargoCapacity;
            annualCost += 3*this.passengerCapacity;
            this.annualMaintenanceCost = annualCost;
            return annualCost;
        }
        else {
            return this.annualMaintenanceCost;
        }
    }

    public int getCargoCapacity(){
        return this.cargoCapacity;
    }
    
    public int getPassengerCapacity(){
        return this.passengerCapacity;
    }

    @Override
    public String toString(){
        String value = "TransportShip" + super.toString() +
        "\n\tCargoCapacity=" + cargoCapacity +
        "\n\tPassengerCapacity=" + passengerCapacity;
        return value;
    }
}
