package com.demo.parking;

public class InvalidInputException extends Exception{
	public InvalidInputException(String input, String expression) {
		super(input + " is not as per expected format: " + expression);
	}
}
