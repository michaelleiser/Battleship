package org.state;

public class Context {

	public enum EventType {
		SelectGameType, Ready, Start, Shoot, Hit, Sunk, Water, Won, Restart
	}

	private State state;

	public Context() {
		setState(new Idle(this));
	}

	public void handle(EventType e) {
		switch (e) {
		case SelectGameType:
			state.handleSelectGameType();
			break;
		case Ready:
			state.handleReady();
			break;
		case Start:
			state.handleStart();
			break;
		case Hit:
			state.handleHit();
			break;
		case Sunk:
			state.handleSunk();
			break;
		case Water:
			state.handleWater();
			break;
		case Won:
			state.handleWon();
			break;
		case Restart:
			state.handleRestart();
			break;
		default:
			break;
		}
	}

	public void setState(State s) {
		state = s;
	}

	public State getState() {
		return state;
	}

}
