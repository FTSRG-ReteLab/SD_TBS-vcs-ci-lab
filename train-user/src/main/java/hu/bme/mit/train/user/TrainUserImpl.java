package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import java.lang.*;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private String userName;

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

	public String getName()
{
return userName;
}
}
