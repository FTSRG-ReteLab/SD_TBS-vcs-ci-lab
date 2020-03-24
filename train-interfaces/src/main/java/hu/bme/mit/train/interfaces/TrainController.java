package hu.bme.mit.train.interfaces;
import com.google.common.collect.*;
public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);
	
	Table<Long,Integer,Integer> getTachometer();

	//for testing
	void setReferenceSpeed(int referenceSpeed);
}
