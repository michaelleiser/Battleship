package ch.bfh.ti.proj1.battleship.state;

public class PlaceShips extends State{

	public PlaceShips(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleReady(){
		super.context.setState(new Start(super.context));
	}
	
}
