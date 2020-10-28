package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides = null;
	
	public RideRepository() {
		this.userRides = new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> ridesList = this.userRides.get(userId);
		if(ridesList == null) {
			this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
		}else {
			this.userRides.get(userId).addAll(Arrays.asList(rides));
		}
	}
	public Ride[] getRides(String userId) {
		ArrayList<Ride> ridesList = this.userRides.get(userId);
		Ride[] ride = ridesList.toArray(new Ride[ridesList.size()]);
		return ride;
	}
}