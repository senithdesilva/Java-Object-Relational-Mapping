package com.hibernate.service;

import com.hibernate.model.CustomerDetails;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class Read {
    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("ORMHibernate");

    // Create an EntityManager
    private static final EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();

    static List read(final String name) {

        List students = null;

        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();
            // Get a List of Students
            students = findWithName(name);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }

    private static List findWithName(final String name) {
        return manager.createQuery(
                "SELECT c FROM CustomerDetails c WHERE c.name LIKE :customer_name", CustomerDetails.class)
                .setParameter("customer_name", name)
                .getResultList();
    }
}
