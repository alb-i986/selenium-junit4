package me.alb_i986.selenium.junit.rules;

import me.alb_i986.BaseMockitoTestClass;
import org.junit.Test;
import org.mockito.Mock;
import org.openqa.selenium.remote.service.DriverService;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.verify;

public class DriverServiceResourceTest extends BaseMockitoTestClass {

    @Mock private DriverService mockedService;

    @Test
    public void nullDriverServiceShouldNotBeAllowed() {
        try {
            new DriverServiceResource(null);
            fail("null DriverService should not be allowed");
        } catch (IllegalArgumentException e) {
            // expected
            assertThat(e.getMessage(), equalTo("The DriverService should not be null"));
        }
    }

    @Test
    public void beforeShouldStartTheService() throws Throwable {
        DriverServiceResource sut = new DriverServiceResource(mockedService);

        // when
        sut.before();

        verify(mockedService).start();
    }

    @Test
    public void afterShouldStopTheService() throws Exception {
        DriverServiceResource sut = new DriverServiceResource(mockedService);

        // when
        sut.after();

        verify(mockedService).stop();
    }
}