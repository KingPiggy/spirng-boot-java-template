package com.kingpiggy.app.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaTest {

    @Test
    @DisplayName("JUnit Test")
    void test_() throws Exception {
        // given
        int a = 10;
        int b = 20;

        // when
        b = decrease10(b);

        // then
        assertEquals(a, b);
    }

    private int decrease10(int n) {
        return n - 10;
    }

}
