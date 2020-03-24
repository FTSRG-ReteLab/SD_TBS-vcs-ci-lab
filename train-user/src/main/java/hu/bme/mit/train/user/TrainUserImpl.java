package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import java.lang.*;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private String userName;
	boolean alarmState = false;

	public TrainUserImpl(){};	

	public TrainUserImpl(TrainController controller, String userName) {
		this.controller = controller;
		this.userName = userName;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

	@Override
	public boolean getAlarmState() {
		return alarmState;
	}

	@Override
	public void setAlarmState(boolean alarmState) {
		this.alarmState = alarmState;
	}

	public String getName()
{
return userName;
}
}
