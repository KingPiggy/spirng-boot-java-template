package com.kingpiggy.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyEnum {

    SAMPLE("sample");

    private final String key;

}
