package org.state;

public class GameOver extends State{

	protected GameOver(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void handleRestart(){
		super.c.setState(new Idle(super.c));
	}
}
