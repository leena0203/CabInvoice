package CabInvoiceGenerator;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class InvoiceServiceTest {

	/**
	 * UC1_CalucalteFare
	 */
	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		double dist = 2.0;
		int time = 5;
		double fare = test.calculateFare(dist, time);
		assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenDistanceAndTime_shouldReturnMinimumFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		double dist = 0.0;
		int time = 1;
		double fare = test.calculateFare(dist, time);
		assertEquals(5, fare);
	}

	/**
	 * UC2_CalculateFareForMultipleRides
	 */
	@Test
	public void givenMultipleRides_shouldReturnTotalFare() {
		InvoiceGenerator test  = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5),
				new Ride(2.0, 8),
				new Ride(0.2, 1),
				new Ride(3.0, 6),			
		};
		double fare = test.calculateFare(rides);
		assertEquals(94, fare, 0.0);
	}

}