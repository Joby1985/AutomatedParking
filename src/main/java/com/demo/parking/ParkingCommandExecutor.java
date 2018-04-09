package com.demo.parking;

import java.util.List;

public interface ParkingCommandExecutor {
	public List<Position> move() throws InvalidInputException;
}
