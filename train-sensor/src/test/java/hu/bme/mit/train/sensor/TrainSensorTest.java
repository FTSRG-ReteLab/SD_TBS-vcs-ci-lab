package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import hu.bme.mit.train.user.TrainUserImpl;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
	TrainUserImpl user;	
    @Before
    public void before() {
        user = new TrainUserImpl();
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertNotEquals("valami",user.getName());
    }
}
