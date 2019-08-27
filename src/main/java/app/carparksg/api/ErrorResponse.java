package app.carparksg.api;

public class ErrorResponse {
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        ErrorResponse errorResponse = (ErrorResponse) object;
        return error.equals(errorResponse.getError());
    }
}