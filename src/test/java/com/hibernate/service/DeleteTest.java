package com.hibernate.service;

import org.testng.annotations.Test;

public class DeleteTest {

    @Test
    public void testDelete() {
        final int id = 01;
        Delete.delete(id);
    }
}