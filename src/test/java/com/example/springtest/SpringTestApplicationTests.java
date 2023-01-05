package com.example.springtest;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
class SpringTestApplicationTests {

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
    void testOne() {
        System.out.println("test1");
        assertNotNull("NOT NULL");
        assertNotEquals("John", "Duke");
        assertThrows(NumberFormatException.class, () -> Integer.valueOf("duke"));
        assertEquals("hello world", "HELLO WORLD".toLowerCase());
    }

    @Test
    void jsonAssertExample() throws JSONException {
        String result = "{\"name\": \"duke\", \"age\":\"42\"}";
        JSONAssert.assertEquals("{\"name\": \"duke\"}", result, false);
    }

    //JSONAssert
    @Test
    void jsonAssertExample2() throws JSONException {

        //Strict order
        String result = "{\"name\": \"duke\", \"age\":\"42\"}";
        JSONAssert.assertEquals("{\"name\": \"duke\"}", result, true);
    }

    //JSONPath
    @Test
    void jsonPathExample() {
        String result = "{\"age\":\"42\", \"name\": \"duke\", \"tags\":[\"java\", \"jdk\"]}";

        // Using JUnit 5 Assertions
        assertEquals(2, JsonPath.parse(result).read("$.tags.length()", Long.class));
        assertEquals("duke", JsonPath.parse(result).read("$.name", String.class));
    }

}
