package org.springjdbc.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;

    private String name;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // foreign key column in employee table
    private Address address;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_laptop",          // join table name
            joinColumns = @JoinColumn(name = "employee_id"),  // FK to Employee
            inverseJoinColumns = @JoinColumn(name = "laptop_id") // FK to Laptop
    )
    private List<Laptop> laptops;




    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {}

    public Employee(int eid, String name, double salary, Address address) {
        this.eid = eid;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    // getters and setters
    public int getEid() { return eid; }
    public void setEid(int eid) { this.eid = eid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                ", department=" + department +
                ", laptops=" + laptops +
                '}';
    }
}
