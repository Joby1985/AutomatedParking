package com.demo.parking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

/**
 * Tests for negative and positive scenarios
 * 
 * @author Joby Job
 *
 */
public class AutomatedParkingTest {

	@Test(expected = InvalidInputException.class)
	public void testInvalidInputFormat() throws Exception {
		String input = "115RFFLF";

		new AutomatedParking(input).move();
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidStartPosition() throws Exception {
		String input = "20,11:FRFLRFL";

		new AutomatedParking(input).move();
	}
	
	@Test(expected = OutOfBoundsException.class)
	public void testOutOfBoundsOverflow() throws Exception {
		String input = "3,14:FF";

		AutomatedParking aParking = new AutomatedParking(input);
		List<Position> moves = aParking.move();
	}
	
	@Test(expected = OutOfBoundsException.class)
	public void testOutOfBoundsUndeflow() throws Exception {
		String input = "1,1:LFF";

		AutomatedParking aParking = new AutomatedParking(input);
		List<Position> moves = aParking.move();
	}

	@Test
	public void testCommnandExecution() throws Exception {
		// data 1
		String input = "5,5:RFLFRFLF";

		AutomatedParking aParking = new AutomatedParking(input);
		List<Position> moves = aParking.move();

		assertThat(moves.size(), is(5));
		Position lastPosition = moves.get(4);
		assertThat(lastPosition.getPosX(), is(7));
		assertThat(lastPosition.getPosY(), is(7));
		
		// data 2
		input = "6,6:FFLFFLFFLFF";
		aParking = new AutomatedParking(input);
		moves = aParking.move();

		assertThat(moves.size(), is(9));
		lastPosition = moves.get(8);
		assertThat(lastPosition.getPosX(), is(6));
		assertThat(lastPosition.getPosY(), is(6));
		
		// data 3
		input = "5,5:FLFLFFRFFF";
		aParking = new AutomatedParking(input);
		moves = aParking.move();

		assertThat(moves.size(), is(8));
		lastPosition = moves.get(7);
		assertThat(lastPosition.getPosX(), is(1));
		assertThat(lastPosition.getPosY(), is(4));
		
		// data 4
		input = "2,1:FLFLFRF";
		aParking = new AutomatedParking(input);
		moves = aParking.move();

		assertThat(moves.size(), is(5));
		lastPosition = moves.get(4);
		assertThat(lastPosition.getPosX(), is(0));
		assertThat(lastPosition.getPosY(), is(1));
	}
}
