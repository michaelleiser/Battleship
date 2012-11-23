package ch.bfh.ti.proj1.battleship.state;

public class GameOver extends State{

	protected GameOver(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void handleRestart(){
		super.context.setState(new Idle(super.context));
	}
}
