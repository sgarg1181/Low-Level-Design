package parking_lot;

public class Vehicle {
	private int vehicleNumber;
	private VehicleType type;
	private ParkingSpot parkingSpot;  // 1--1 mapping between parking spot and vehicle
	
	public Vehicle( VehicleType type) {
		this.type = type;
	}
	
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}	
	
	
}
