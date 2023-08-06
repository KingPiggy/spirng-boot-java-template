package com.kingpiggy.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    ROLE_SUPER_ADMIN("SUPER_ADMIN"),
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private final String key;

}
