package CabInvoiceGenerator;

public class InvoiceGenerator {
	private double MIN_COST_PER_KILOMETER = 10.0;
	private int COST_PER_TIME = 1;
	private double MIN_FARE = 5.0;

	/**
	 * UC1_calculate fare for rides
	 * @param dist
	 * @param time
	 * @return
	 */
	public double calculateFare(double dist, int time) {
		double fare = (dist*MIN_COST_PER_KILOMETER + time*COST_PER_TIME);
		System.out.println("Total Fare: "+fare);
		return Math.max(fare, MIN_FARE);

	}

	/**
	 * UC2,3_Calaculate total fare for multiple rides and generate invoice summary
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.dist, ride.time);
		}
		System.out.println("Total Fare: "+totalFare);
		InvoiceSummary summary  = new InvoiceSummary(rides.length, totalFare);
		return summary;
	}


}
