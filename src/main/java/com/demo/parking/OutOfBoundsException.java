package com.demo.parking;

public class OutOfBoundsException extends RuntimeException{
	public OutOfBoundsException(Position position) {
		super("Out of bounds at position " + position.getPosX() + "," + position.getPosY());
	}
}
