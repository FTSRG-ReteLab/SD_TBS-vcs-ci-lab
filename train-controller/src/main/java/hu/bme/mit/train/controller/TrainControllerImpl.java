package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import com.google.common.collect.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainControllerImpl implements TrainController {
	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Table<Long, Integer, Integer> table = new ImmutableTable.Builder<Long, Integer, Integer>().put(System.currentTimeMillis(), step, referenceSpeed).build();
	private Thread thread;
	Logger logger = Logger.getLogger(TrainControllerImpl.class.getName());

	public TrainControllerImpl(){
		thread=new Thread() {
			public void run() {
				thread.run();
				try {
					followSpeed();
					thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.log(Level.SEVERE,"Got InterruptedException");
				}

			}
		};
	}
	
	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}
	
	public Table<Long,Integer,Integer> getTachometer(){return table;}
}
