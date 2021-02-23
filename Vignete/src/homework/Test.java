package homework;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import homework.Vignette.Validity;

public class Test {
	
	private static final String[] CAR_MODELS = new String[] {
		"Citroen", "Renault", "Peugeot", "Mercedes", "BMW", "Audi"
	};
	
	private static final String[] BUS_MODELS = new String[] {
		"Mercedes", "Ikarbus", "Scania"
	};
	
	private static final String[] TRUCK_MODELS = new String[] {
		"Mercedes", "MAN", "Iveco"
	};

	public static void main(String[] args) {
		GasStation gasStation = new GasStation();
		System.out.println(gasStation);

		Random random = new Random();

		Driver[] drivers = new Driver[20];
		for (int i = 0; i < drivers.length; i++) {
			drivers[i] = new Driver("Driver " + (i + 1));
			drivers[i].setMoney(random.nextInt(5000) + 5000);
			drivers[i].setGasStation(gasStation);
		}

		for (int i = 0; i < drivers.length; i++) {
			for (int j = 0; j < 10; j++) {
				drivers[i].addVehicle(createRandomVehicle(random));
			}
		}
		
		for (int i = 0; i < drivers.length; i++) {
			if (i % 3 == 0) {
				int[] randomIndexes = getRandomIndexes(random, 5, 10);
				
				for (int j = 0; j < randomIndexes.length; j++) {
					drivers[i].buyVignette(randomIndexes[j], getRandomValidity(random));
				}
			} else {
				drivers[i].buyVignettes(getRandomValidity(random));
			}
		}
		
		Calendar calendar = new GregorianCalendar();
		
		for (int i = 0; i < drivers.length; i++) {
			System.out.println(drivers[i]);
			System.out.println("vehicles with invalid vignette: " + 
					drivers[i].getVehiclesWithInvalidVignettes(
							calendar.get(Calendar.DAY_OF_MONTH) - 1, 
							calendar.get(Calendar.MONTH),
							calendar.get(Calendar.YEAR)));
		}
		
		System.out.println(Arrays.toString(gasStation.getRemainingVignettes()));
		
		for (int i = 0; i < drivers.length; i++) {
			Vehicle[] vehiclesWithInvalidVignettes = drivers[i].getVehiclesWithInvalidVignettes(
					calendar.get(Calendar.DAY_OF_MONTH) - 1, 
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.YEAR));
			
			for (int j = 0; j < vehiclesWithInvalidVignettes.length; j++) {
				if (vehiclesWithInvalidVignettes[j].getVehicleType() == VehicleType.TRUCK) {
					System.out.println(vehiclesWithInvalidVignettes[j]);
				}
			}
		}
	}

	private static Vehicle createRandomVehicle(Random random) {
		VehicleType randomVehicleType = getRandomVehicleType(random);
		
		switch (randomVehicleType) {
			case CAR:
				return new Car(CAR_MODELS[random.nextInt(CAR_MODELS.length)], 
						generateRandomManufactureYear(random));
			case BUS:
				return new Bus(BUS_MODELS[random.nextInt(BUS_MODELS.length)], 
						generateRandomManufactureYear(random));
			case TRUCK:
				return new Bus(TRUCK_MODELS[random.nextInt(TRUCK_MODELS.length)], 
						generateRandomManufactureYear(random));
			default:
				return null;
		}
	}

	private static int generateRandomManufactureYear(Random random) {
		return 2015 - random.nextInt(10);
	}

	private static VehicleType getRandomVehicleType(Random random) {
		int vehicleType = random.nextInt(3);

		switch (vehicleType) {
		case 0:
			return VehicleType.CAR;
		case 1:
			return VehicleType.BUS;
		case 2:
			return VehicleType.TRUCK;
		default:
			return null;
		}
	}
	
	private static int[] getRandomIndexes(Random random, int number, int indexesCount) {
		int[] indexes = new int[number];
		int current = 0;
		
		for (int i = 0; i < number; i++) {
			while (true) {
				int nextInt = random.nextInt(indexesCount);
				
				if (!contains(indexes, nextInt)) {
					indexes[current++] = nextInt;
					break;
				}
			}
		}
		
		return indexes;
	} 
	
	private static boolean contains(int[] indexes, int index) {
		for (int i = 0; i < indexes.length; i++) {
			if (indexes[i] == index) {
				return true;
			}
		}
		
		return false;
	}
	
	private static Validity getRandomValidity(Random random) {
		int randomInt = random.nextInt(3);
		
		switch (randomInt) {
			case 0:
				return Validity.VALIDITY_DAY;
			case 1:
				return Validity.VALIDITY_MONTH;
			case 2:
				return Validity.VALIDITY_YEAR;
			default:
				return null;
		}
	}
}
