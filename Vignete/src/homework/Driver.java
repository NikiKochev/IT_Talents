package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import homework.Vignette.Validity;

public class Driver {

	private final String name;
	private final List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private float money;
	private GasStation gasStation;

	public Driver(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void setMoney(float money) {
		this.money = money;
	}
	
	public float getMoney() {
		return money;
	}
	
	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}
	
	public void buyVignette(int vehicleNumber, Validity validity) {
		if (gasStation != null && vehicleNumber >= 0 && vehicleNumber < vehicles.size()) {
			Vehicle vehicle = vehicles.get(vehicleNumber);
			Vignette vignette = gasStation.buyVignette(vehicle.getVehicleType(), validity);
			
			if (vignette != null) {
				money -= vignette.getPrice();
				vehicle.setVignette(vignette);
			}
		}
	}
	
	public void buyVignettes(Validity validity) {
		for (int i = 0; i < vehicles.size(); i++) {
			buyVignette(i, validity);
		}
	}
	
	public Vehicle[] getVehiclesWithInvalidVignettes(int day, int month, int year) {
		List<Vehicle> result = new LinkedList<Vehicle>();
		Iterator<Vehicle> vehiclesIterator = vehicles.iterator();
		
		while (vehiclesIterator.hasNext()) {
			Vehicle next = vehiclesIterator.next();
			
			if (!hasValidVignette(next, day, month, year)) {
				result.add(next);
			}
		}
		
		return result.toArray(new Vehicle[result.size()]);
 	} 
	
	private boolean hasValidVignette(Vehicle vehicle, int day, int month, int year) {
		Vignette vignette = vehicle.getVignette();
		
		if (vignette == null) {
			return false;
		}
		
		return vignette.isValid(new SimpleDate(day, month, year));
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", vehicles=" + vehicles + ", money=" + money + "]";
	}
}
