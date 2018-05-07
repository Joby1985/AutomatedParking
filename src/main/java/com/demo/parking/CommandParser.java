package com.demo.parking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser to parse start position and the Forward/Left/Right command sets.
 * 
 * @author Joby Job
 *
 */
public class CommandParser {
	
	public final String INPUT_COMMAND_EXPR = "([0-9]|1[0-5]),([0-9]|1[0-5]):([FLR]+)";
	
	private String input;
	
	private Position startPosition;
	private String command;
	
	CommandParser(String input){
		this.input = input;
	}
	
	public void executeCommand() throws InvalidInputException {
		Matcher matcher = Pattern.compile(INPUT_COMMAND_EXPR).matcher(input);

		if (!matcher.matches()) {
			throw new InvalidInputException(input, INPUT_COMMAND_EXPR);
		}

		int xPos = Integer.parseInt(matcher.group(1));
		int yPos = Integer.parseInt(matcher.group(2));

		startPosition = new Position(xPos, yPos);
		command = matcher.group(3);
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public String getCommand() {
		return command;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
