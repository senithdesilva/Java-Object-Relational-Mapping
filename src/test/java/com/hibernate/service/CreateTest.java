package com.hibernate.service;

import com.hibernate.model.CustomerDetails;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateTest {

    @Test
    public void testCreate() {
        Create.create(1, "senith", "No where");
        Create.create(2, "bob", "phillip");
    }
}