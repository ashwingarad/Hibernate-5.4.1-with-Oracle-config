package com.client;

import com.config.HibernateUtil;
import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;


public class Test {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        try {
            Employee employee = new Employee();
            employee.setEname("Ashwin");
            employee.setSalary(39000);

            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

            System.out.println(transaction.getStatus() == TransactionStatus.COMMITTED);
        } finally {
            session.close();
            HibernateUtil.closeFactory();
        }
    }
}
