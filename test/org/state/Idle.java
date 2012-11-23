package org.state;

public class Idle extends State {

	Idle(Context c) {
		super(c);
	}
	
	@Override
	protected void handleSelectGameType(){
		super.context.setState(new PlaceShips(super.context));
	}

}
