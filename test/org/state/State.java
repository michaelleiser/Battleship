package org.state;

public abstract class State {
	
	protected Context c;
	
	protected State(Context c){
		this.c = c;
	}
	
	final void entry(){
		doEntry();
		startDo();
	}
	
	protected void startDo() {
		// TODO Auto-generated method stub
		
	}

	protected void doEntry() {
		// TODO Auto-generated method stub
		
	}

	final void exit(){
		stopDo();
		doExit();
	}

	protected void doExit() {
		// TODO Auto-generated method stub
		
	}

	protected void stopDo() {
		// TODO Auto-generated method stub
		
	}

	void handleSelectGameType() {
		// TODO Auto-generated method stub
		
	}

	void handleReady() {
		// TODO Auto-generated method stub
		
	}

	void handleStart() {
		// TODO Auto-generated method stub
		
	}


	void handleHit() {
		// TODO Auto-generated method stub
		
	}

	void handleSunk() {
		// TODO Auto-generated method stub
		
	}

	void handleWater() {
		// TODO Auto-generated method stub
		
	}

	void handleWon() {
		// TODO Auto-generated method stub
		
	}

	void handleRestart() {
		// TODO Auto-generated method stub
		
	}
	
	

}