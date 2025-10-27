package org.springjdbc;

/**
 * Hello world!
 *
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springjdbc.model.Address;
import org.springjdbc.model.Department;
import org.springjdbc.model.Employee;
import org.springjdbc.model.Laptop;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Step 1: Load Hibernate configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");  // looks for hibernate.cfg.xml in resources
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Address.class);

        // Step 2: Create SessionFactory and open Session
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Step 3: Begin transaction
        Transaction tx = session.beginTransaction();

        Laptop laptop1 = new Laptop("HP", 123);
        Laptop laptop2 = new Laptop("Dell", 150);
        Laptop laptop3 = new Laptop("Lenovo", 200);

        Address addr1 = new Address("Pune");
        Address addr2 = new Address("Mumbai");

        Department dept = new Department();
        dept.setAddress("Pune Branch");

        Employee emp1 = new Employee();
//        emp1.setEid(1);
        emp1.setName("Sanket");
        emp1.setSalary(50000);
        emp1.setAddress(addr1);
        emp1.setDepartment(dept);
        emp1.setLaptops(Arrays.asList(laptop1, laptop2));

        Employee emp2 = new Employee();
//        emp2.setEid(2);
        emp2.setName("Ramesh");
        emp2.setSalary(45000);
        emp2.setAddress(addr2);
        emp2.setDepartment(dept);
        emp2.setLaptops(Arrays.asList(laptop3)); // ✅ Corrected assignment for emp2

        dept.setEmployeeList(Arrays.asList(emp1, emp2));

        // Step 8: Persist only department (cascade will handle employees, addresses, laptops)
        session.persist(dept);
        tx.commit();

        //        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();

        // ✅ Printing the data
//        for (Employee emp : employeeList) {
////            System.out.println("ID: " + emp.getEid());
////            System.out.println("Name: " + emp.getName());
////            System.out.println("Salary: " + emp.getSalary());
//            System.out.println(emp);
//
//            if (emp.getAddress() != null) {
//                System.out.println("Address: " + emp.getAddress().getAddress());
//            }
//
//            System.out.println("-------------------------------------");
//        }

        // Step 6: Commit transaction
//        tx.commit();

        // Step 7: Close session and factory
//        session.close();
//        sessionFactory.close();

        System.out.println("✅ Employee and Address saved successfully!");
    }
}

/*
*
* git init
git add .
git commit -m "Initial commit - Hibernate Practice Project"
git branch -M main
git remote add origin https://github.com/SanketWalave/HibernatePractice.git
git push -u origin main
*/
