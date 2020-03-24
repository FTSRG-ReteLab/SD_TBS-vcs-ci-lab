package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
	public TrainUser mockTrainUser;
    public TrainController mockTrainController;
    public TrainSensor sensor;

    @Before
    public void before(){
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockTrainController,mockTrainUser);
        mockTrainController.setReferenceSpeed(150);
    }

    @Test
    public void AlarmStateIfSpeedLimitIsLessThanZero(){
        sensor.overrideSpeedLimit(-1);
        verify(mockTrainUser,times(1)).setAlarmState(true);
    }

    @Test
    public void AlarmStateIfSpeedLimitIsMoreThan500(){
        sensor.overrideSpeedLimit(501);
        verify(mockTrainUser,times(1)).setAlarmState(true);
    }

    @Test
    public void AlarmStateIfRelativeChangeInSpeedLimitIsMoreThan50Percent()
    {
        when(mockTrainController.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(50);
        verify(mockTrainUser,times(1)).setAlarmState(true);
    }

    @Test
    public void AlarmStateIfSpeedLimitIsBetweenBothMargins()
    {
        when(mockTrainController.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(151);
        verify(mockTrainUser,times(0)).setAlarmState(true);
    }
}
