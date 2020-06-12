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
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetIdByValue() {

    }

    @Test
    public void testCountPeople() {

    }

    @Test
    public void testListPeople() {

    }
}
