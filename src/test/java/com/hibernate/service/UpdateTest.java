package com.hibernate.service;

import com.hibernate.model.CustomerDetails;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateTest {

    @Test
    public void testUpdate() {
        final int id = 1;
        final String name = "Sam";
        final String address = "Bruce";

        Update.update(id, name, address);

        List<CustomerDetails> customer = Read.read(name);

        if (StringUtils.isNotEmpty(String.valueOf(customer))) {
            for (CustomerDetails item: customer) {
                Assert.assertEquals(id, item.getId(), "Mismatch IDs");
                Assert.assertEquals(name, item.getName(), "Created name: " + name + " is not equal to the returned name: " + item.getName());
                Assert.assertEquals(address, item.getAddress(), "Created address: " + address + " is not equal to the returned address: " + item.getAddress());
            }
        } else {
            Assert.fail("customer " + name +" is empty");
        }
    }
}