package com.demo.parking;

import java.util.List;

public class SimpleConsoleMovementPlotter implements MovementPlotter{

	@Override
	public void plotMovement(List<Position> positions, String input) {
		int sequence = 0;

		System.out.println("*********************** ("+input+") ****************************");
		for(int i=14; i > -1; i--) {
			for(int k=0; k < 15; k++) {
				Position p = new Position(k, i);
				if((sequence = positions.indexOf(p)) > -1) {
					System.out.printf("%3s",sequence+1);
				}
				else {
					System.out.printf("%3s","-");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
	}

}
