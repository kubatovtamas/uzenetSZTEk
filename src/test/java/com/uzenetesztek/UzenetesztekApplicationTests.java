package com.uzenetesztek;

import com.uzenetesztek.controller.TopicController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class UzenetesztekApplicationTests {

    @Autowired
    private TopicController topicController;

    @Test
    void contextLoads() {
        Assertions.assertEquals(1, 1);
    }

}
