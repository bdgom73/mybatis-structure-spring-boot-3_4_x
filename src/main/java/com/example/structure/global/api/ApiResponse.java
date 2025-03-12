package com.example.structure.global.api;

import lombok.Getter;

@Getter
public class ApiResponse {

    private int code;
    private int status;
    private String message;
    public ApiResponse(int code, int status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public static ApiResponse ok() {
        return new ApiResponse(0, 200, "SUCCESS");
    }
}
