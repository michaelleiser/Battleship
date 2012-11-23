package ch.bfh.ti.proj1.battleship.state;

public class Player2Turn extends State{

	protected Player2Turn(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void handleHit(){
		super.context.setState(new Player2Turn(super.context));
	}
	
	@Override
	protected void handleSunk(){
		super.context.setState(new Player2Turn(super.context));
	}
	
	@Override
	protected void handleWater(){
		super.context.setState(new Player1Turn(super.context));
	}
	
	@Override
	protected void handleWon(){
		super.context.setState(new GameOver(super.context));
	}
	
}
