package com.example.structure.global.page;

public record Page<T>(
        Pageable pageable,
        T data
) {
}
