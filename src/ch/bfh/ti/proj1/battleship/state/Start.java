package ch.bfh.ti.proj1.battleship.state;

public class Start extends State{

	protected Start(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void handleStart(){
		super.context.setState(new Player1Turn(super.context));
	}

}