package com.gloryh.test;

import com.gloryh.entity.Customer;
import com.gloryh.entity.Orders;
import com.gloryh.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 黄光辉
 * @since 2020/8/24
 **/
public class Test2 {
    public static void main(String[] args) {
        // 创建Configuration
        Configuration configuration = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 获取Session
        Session session = sessionFactory.openSession();
        Customer customer = new Customer();
        customer.setName("王五");

        Orders orders1=new Orders();
        orders1.setName("订单1");
        orders1.setCustomer(customer);

        Orders orders2=new Orders();
        orders2.setCustomer(customer);
        orders2.setName("订单2");

        Set<Orders> orders =new HashSet<>();
        orders.add(orders1);
        orders.add(orders2);
        customer.setOrders(orders);

        session.save(customer);
        session.save(orders1);
        session.save(orders2);
        session.beginTransaction().commit();
        session.close();
    }
}
