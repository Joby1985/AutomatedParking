package com.demo.parking;

import java.util.ArrayList;
import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

// Change 2

/**
 * Main class to imp.lement parking command
 * 
 
 * @author Joby Job
 *
 */
public class AutomatedParking implements ParkingCommandExecutor{
	
	public static int GRID_MAX_X_VALUE = 15;
	public static int GRID_MAX_Y_VALUE = 15;
	
	//static Logger logger = LoggerFactory.getLogger(AutomatedParking.class);
	
	CommandParser parser;
	
	public AutomatedParking(String input){
		parser = new CommandParser(input);
	}

	public List<Position> move() throws InvalidInputException {
		parser.executeCommand();
		
		Position initialPos = parser.getStartPosition();
		String command = parser.getCommand();
		
		List<Position> positions = new ArrayList<Position>();
		positions.add(initialPos);
		Position positon = initialPos;
				
		for(int i = 0, n = command.length() ; i < n ; i++) {
		    char code = command.charAt(i);
		    positon = new Position(positon);
		    if(code == Position.RIGHT) {
		    	positon.turnRight();
		    }
		    else if(code == Position.LEFT) {
		    	positon.turnLeft();
		    }
		    else {
		    	positon.moveForward();
		    	//Store new positions, when there is a movement
			    positions.add(positon);
		    }
		}
		MovementPlotter plotter = new SimpleConsoleMovementPlotter();
		plotter.plotMovement(positions, parser.getInput());
		return positions;
	}
	
	public static void main(String[] args) {
		if (args == null || args.length == 0 || args.length > 1) {
			System.out.println("Usage com.demo.parking.AutomatedParking <input>");
			return;
		}
		AutomatedParking automatedParking = new AutomatedParking(args[0]);
		List<Position> moves = null;
		
		try {
			moves = automatedParking.move();
		}
		catch(InvalidInputException ex) {
			//logger.error("Invalid Input ",ex);
			System.out.println("Invalid Input "+ex.getMessage());
		}
		if(moves != null) {
			Position finalPosition = null;
			for(Position p : moves) {
				finalPosition = p;
			}
			System.out.println(finalPosition);
		}
	}
}
