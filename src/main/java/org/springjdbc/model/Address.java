package org.springjdbc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;

    private String address;

    public Address() {}

    public Address( String address) {
        this.address = address;
    }

    // getters and setters
    public int getaId() { return aId; }
    public void setaId(int aId) { this.aId = aId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", address='" + address + '\'' +
                '}';
    }
}
