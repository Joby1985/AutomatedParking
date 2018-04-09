package com.demo.parking;

/**
 * Class that encapsulates position and its processing with respect to direction
 * 
 * @author Joby Joby
 *
 */
public class Position {
	private int posX;
	private int posY;
	
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';
	
	enum Direction {
		EAST,NORTH,WEST,SOUTH;
	}
	
	private Direction direction = Direction.NORTH; // default
	
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public Position(Position input) {
		this(input.posX, input.posY);
		this.direction = input.direction;
	}

	
	public void turnLeft() {
		this.direction = Direction.values()[(direction.ordinal()+1)%4];
	}

	public void turnRight() {
		this.direction = Direction.values()[(direction.ordinal()+3)%4];
	}
	
	public void moveForward() {
		switch(direction) {
			case EAST: posX++; break;
			case NORTH: posY++; break;
			case WEST: posX--; break;
			case SOUTH: posY--; break;
		}
		if(posX > AutomatedParking.GRID_MAX_X_VALUE || posX < 0 ||
				posY > AutomatedParking.GRID_MAX_Y_VALUE || posY < 0) {
			throw new OutOfBoundsException(this);
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Direction getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Position [" + posX + ", " + posY + "]";
	}
}
