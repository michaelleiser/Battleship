package org.state;

public class PlaceShips extends State{

	public PlaceShips(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleReady(){
		super.c.setState(new Start(super.c));
	}
	
}
