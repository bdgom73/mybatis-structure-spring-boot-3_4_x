package com.example.structure.global.api;

import lombok.Getter;

@Getter
public class DataResponse<T> {
    T data;

    public DataResponse(T data) {
        this.data = data;
    }

    public static <T> DataResponse<T> send(T data) {
        return new DataResponse<>(data);
    }
}
