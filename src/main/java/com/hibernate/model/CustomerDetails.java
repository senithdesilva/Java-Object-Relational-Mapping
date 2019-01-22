package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerDetails implements Serializable{
    @Id
    @Column(name = "customer_id", unique = true)
    private int id;

    @Column(name = "customer_name", unique = true)
    private String name;

    @Column(name = "customer_address", unique = true)
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + address;
    }
}
