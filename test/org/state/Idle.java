package org.state;

public class Idle extends State {

	Idle(Context c) {
		super(c);
	}
	
	@Override
	protected void handleSelectGameType(){
		super.c.setState(new PlaceShips(super.c));
	}

}
