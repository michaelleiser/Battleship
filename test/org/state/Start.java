package org.state;

public class Start extends State{

	protected Start(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void handleStart(){
		super.c.setState(new Player1Turn(super.c));
	}

}
