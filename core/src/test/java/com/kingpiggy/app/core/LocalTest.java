package com.kingpiggy.app.core;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

@Transactional
@ActiveProfiles({"core", "local"})
@SpringBootTest
public class LocalTest {
}
