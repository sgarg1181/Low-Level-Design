package parking_lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<CompactSpot> compactSpotList = new ArrayList<>();
	private List<LargeSpot> largeSpotList = new ArrayList<>();
	private List<BikeSpot> bikeSpotList = new ArrayList<>();
	
	private int freeCompactSpot;
	private int freeLargeSpot;
	private int freeBikeSpot;
	
	public ParkingLot(int freeCompactSpot, int freeLargeSpot, int freeBikeSpot) {
		this.freeBikeSpot = freeBikeSpot;
		this.freeLargeSpot = freeLargeSpot;
		this.freeCompactSpot = freeCompactSpot;
	}
	
	public void parkVehicle(Vehicle vehicle) {
		System.out.println("we are going to park "+vehicle.getType());
		
		if(vehicle.getType().equals(VehicleType.TRUCK)) {
			if(this.freeLargeSpot>0) {
				parkLargeVehicle(vehicle);
			}
			else {
				System.out.println("All Sport Are Full");
			}
		}
		else if(vehicle.getType().equals(VehicleType.CAR)) {
			if(this.freeCompactSpot>0) {
				parkCompactVehicle(vehicle);
			}
			else if(this.freeLargeSpot>0) {
				parkLargeVehicle(vehicle);
			}
			else {
				System.out.println("All Compact/Large Sport Are Full");
			}
		}
		else if (vehicle.getType().equals(VehicleType.BIKE)) {
			if(this.freeBikeSpot>0) {
				parkBikeVehicle(vehicle);
			}
			else if(this.freeCompactSpot>0) {
				parkCompactVehicle(vehicle);
			}
			else if(this.freeLargeSpot>0) {
				parkLargeVehicle(vehicle);
			}
			else {
				System.out.println("All Sports Are Full");
			}
		}
		
	}
	
	private void parkLargeVehicle(Vehicle vehicle){
		LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
		largeSpot.setFree(false);
		largeSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(largeSpot);
		
		largeSpotList.add(largeSpot);
		System.out.println("Parked Large Vehicle");
		this.freeLargeSpot--;
	}
	
	private void parkCompactVehicle(Vehicle vehicle){
		CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
		compactSpot.setFree(false);
		compactSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(compactSpot);
		
		this.compactSpotList.add(compactSpot);
		System.out.println("Parked Compact Vehicle");
		this.freeCompactSpot--;
	}
	
	private void parkBikeVehicle(Vehicle vehicle){
		BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
		bikeSpot.setFree(false);
		bikeSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(bikeSpot);
		
	    this.bikeSpotList.add(bikeSpot);
		System.out.println("Parked Bike Vehicle");
		this.freeBikeSpot--;
	}
	
	public void unparkVehicle(Vehicle vehicle) {
		System.out.println("we are going to Unpark "+vehicle.getType());
		
		ParkingSpot pspot = vehicle.getParkingSpot();
		pspot.setFree(true);
		
		if(vehicle.getType().equals(VehicleType.TRUCK)) {
			
			if(this.largeSpotList.remove(vehicle.getParkingSpot())) {
				System.out.println("Removed Truck Vehicle");
				this.freeLargeSpot++;	
			}
			else {
				System.out.println("No Vehicle at this parking lot");
			}
		}
		else if (vehicle.getType().equals(VehicleType.CAR)) {

			if(this.compactSpotList.remove(vehicle.getParkingSpot()))
			{
				System.out.println("Removed Car Vehicle");
				this.freeCompactSpot++;
			}
			else {
				System.out.println("No Vehicle at this parking lot");
			}
		}
		else if (vehicle.getType().equals(VehicleType.BIKE)) {
			if(this.bikeSpotList.remove(vehicle.getParkingSpot())) {
				System.out.println("Removed Bike Vehicle");
				this.freeBikeSpot++;		
			}
			else {
				System.out.println("No Vehicle at this parking lot");
			}
		}
	}
	
	
}
