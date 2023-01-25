package com.example.springtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
class ITSpringTestApplication {

    @BeforeEach
    void setup() {
        // setup tasks like populating sample data
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown() {
        // cleanup tasks like deleting database rows
        System.out.println("After each test");

    }

    @Test
    void itTestOne() {
        System.out.println("test1");
        assertNotNull("NOT NULL");
        assertNotEquals("John", "Duke");
        assertThrows(NumberFormatException.class, () -> Integer.valueOf("duke"));
        assertEquals("hello world", "HELLO WORLD".toLowerCase());
    }

}
