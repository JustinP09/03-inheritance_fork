package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Cat {
	private static final Logger logger = LogManager.getLogger();


	// initially, animals are sleeping
	private State state = new SleepingState(getSleep());

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;


	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
	}

	public void tick(){
		state = state.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if(state instanceof SleepingState){
			HungryState h = new HungryState(getAwake());
			state = h.feed(this);
		}
		else {
			state = ((HungryState) state).feed(this);
		}
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeathState;
	}

	public int getSleep() {return sleep;}
	public int getAwake() {return awake;}
	public int getDigest() {return digest;}
	public String getName() {return name;}

	@Override
	public String toString() {
		return name;
	}

}
