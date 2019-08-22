package app.carparksg.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testEqualsIsSameObject() {
        assertTrue(errorResponse.equals(errorResponse));
    }

    @Test
    public void testEqualsDifferentObject() {
        ErrorResponse newErrorResponse = new ErrorResponse(this.error);
        assertTrue(errorResponse.equals(newErrorResponse));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(errorResponse.equals(null));
    }


}