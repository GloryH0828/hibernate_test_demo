package com.gloryh.test;

import com.gloryh.entity.Customer;
import com.gloryh.entity.Orders;
import com.gloryh.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * HQL语句练习
 *
 * @author 黄光辉
 * @since 2020/8/25
 */
public class HQLTest {
  public static void main(String[] args) {
    HQLTest.select();
  }

  public static void select() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    System.out.println(configuration);
    // 获取SessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取Session
    Session session = sessionFactory.openSession();
    // 定义HQL语句
    String hql1 = "from Customer where name = :name";
    Query query1 = session.createQuery(hql1);
    query1.setString("name", "张三");
    Customer customer = (Customer) query1.uniqueResult();
    String hql2 = "from Orders where customer = :customer";
    Query query2 = session.createQuery(hql2);
    query2.setEntity("customer", customer);
    List<Orders> list = query2.list();
    for (Orders order : list) {
      System.out.println(order);
    }
    session.close();
  }
}
