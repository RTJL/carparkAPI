package app.carparksg.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ErrorResponseTest {
    
    private String error;
    private ErrorResponse errorResponse;

    @Before
    public void setUp() {
        this.error = "New Error Message";
        ErrorResponse errorResponse = new ErrorResponse(error);
        this.errorResponse = errorResponse;
    }

    @Test
    public void testGetError() {
        assertEquals(error, errorResponse.getError());
    }


}