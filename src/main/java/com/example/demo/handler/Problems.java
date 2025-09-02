package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public final class Problems {
    private Problems() {
    }

    public static ProblemDetail of(HttpStatus status, String detail, String path) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status, detail);
        pd.setProperty("path", path);
        pd.setProperty("timestamp", java.time.OffsetDateTime.now());
        return pd;
    }
}
