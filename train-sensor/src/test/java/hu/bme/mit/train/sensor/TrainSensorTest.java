package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController controller;
	TrainUser user;
	TrainSensorImpl sensor;
    @Before
    public void before() {
        controller=mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor=new TrainSensorImpl(controller,user);
    }

    @Test
    public void averageSpeedTest(){
        sensor.overrideSpeedLimit(controller.getReferenceSpeed()/2);
        verify(user,times(1)).setAlarmState(false);
    }

    @Test
    public void belowAbsoluteSpeedTest(){
        sensor.overrideSpeedLimit(-2);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void aboveAbsoluteSpeedTest(){
        sensor.overrideSpeedLimit(600);
        verify(user,times(1)).setAlarmState(true);
    }

    @Test
    public void referenceSpeedTest(){
        sensor.overrideSpeedLimit((controller.getReferenceSpeed()/2)-1);
        verify(user,times(1)).setAlarmState(true);
    }
}
