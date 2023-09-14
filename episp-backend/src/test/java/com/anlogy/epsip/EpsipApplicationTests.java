package com.anlogy.epsip;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EpsipApplicationTests {

    @Autowired
    private IStaffService staffService;

    @Test
    void contextLoads() {
        System.out.println(staffService.getStaffByName("22"));
    }

}
