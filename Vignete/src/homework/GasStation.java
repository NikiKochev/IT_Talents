package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import homework.Vignette.Validity;

public class GasStation {
	
	private final List<Vignette> vignettes = new ArrayList<Vignette>(10000);
	private float turnover;
	
	public GasStation() {
		this.turnover = 0.0f;
		createVignettes();
	}
	
	public float getTurnover() {
		return turnover;
	}
	
	public Vignette buyVignette(VehicleType vehicle, Validity validity) {
		Iterator<Vignette> vignettesIterator = vignettes.iterator();
		
		while (vignettesIterator.hasNext()) {
			Vignette next = vignettesIterator.next();
			if (next.getVehicleType() == vehicle && next.getValidityType() == validity) {
				vignettesIterator.remove();
				turnover += next.getPrice();
				next.setStartDate(new SimpleDate());
				return next;
			}
		}
		
		return null;
	}
	
	public Vignette[] getRemainingVignettes() {
		return vignettes.toArray(new Vignette[vignettes.size()]);
	}
	
	private void createVignettes() {
		Random random = new Random();
		
		for (int i = 0; i < 10000; i++) {
			vignettes.add(createRandomVignette(random));
		}
		
		Collections.sort(vignettes, new Comparator<Vignette>() {
			@Override
			public int compare(Vignette o1, Vignette o2) {
				return Float.compare(o1.getPrice(), o2.getPrice());
			}
		});
	}
	
	private static Vignette createRandomVignette(Random random) {
		int vehicleType = random.nextInt(3);
		
		switch (vehicleType) {
			case 0:
				return new CarVignette(getRandomValidity(random));
			case 1:
				return new BusVignette(getRandomValidity(random));
			case 2:
				return new TruckVignette(getRandomValidity(random));
			default:
				return null;
		}
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

	@Override
	public String toString() {
		return "GasStation [vignettes=" + vignettes + ", turnover=" + turnover + "]";
	}
	
	
}
