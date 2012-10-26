package org.state;

public class Player2Turn extends State{

	protected Player2Turn(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void handleHit(){
		super.c.setState(new Player2Turn(super.c));
	}
	
	@Override
	protected void handleSunk(){
		super.c.setState(new Player2Turn(super.c));
	}
	
	@Override
	protected void handleWater(){
		super.c.setState(new Player1Turn(super.c));
	}
	
	@Override
	protected void handleWon(){
		super.c.setState(new GameOver(super.c));
	}
	
}
