package com.hibernate.service;

import com.hibernate.model.CustomerDetails;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class ReadTest {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(CreateTest.class.getName());

    @Test
    public void testRead() {
        final String customerName = "test";
        List<CustomerDetails> customer = Read.read(customerName);

        if (StringUtils.isNotEmpty(String.valueOf(customer))) {
            for (CustomerDetails item: customer) {
                LOGGER.info("Customer ID: " + item.getId());
                LOGGER.info("Customer Name: " + item.getName());
                LOGGER.info("Customer Address: " + item.getAddress());
            }
        } else {
            Assert.fail("customer " + customerName +" is empty");
        }
    }
}