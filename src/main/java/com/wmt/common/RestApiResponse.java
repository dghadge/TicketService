package com.wmt.common;

public class RestApiResponse {

    public static enum Status {
        OK,
        ERROR
    }
    
    public static final class RestApiError {

        private final int errorCode;
        private final String description;

        public RestApiError(int errorCode, String description) {
            this.errorCode = errorCode;
            this.description = description;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getDescription() {
            return description;
        }
    }

    private final Status status;
    private final Object data;
    private final RestApiError error;

    public RestApiResponse(Status status, Object data) {
        this(status, data, null);
    }

    public RestApiResponse(Status status, Object data, RestApiError error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public RestApiError getError() {
        return error;
    }
}
