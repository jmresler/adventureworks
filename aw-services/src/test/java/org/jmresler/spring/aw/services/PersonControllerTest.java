package org.jmresler.spring.aw.services;


import org.jmresler.spring.aw.repositories.PersonRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonControllerTest {

    @Autowired protected PersonRepository pRepository;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testGetIdByValue() {

    }

    @Test
    void testCountPeople() {

    }

    @Test
    void testListPeople() {

    }
}
