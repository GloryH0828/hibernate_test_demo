package com.gloryh.test;

import com.gloryh.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author 黄光辉
 * @since 2020/8/24
 **/
public class Test3 {
  public static void main(String[] args) {
      // 创建Configuration
      Configuration configuration = new Configuration().configure();
      // 获取SessionFactory
      SessionFactory sessionFactory = configuration.buildSessionFactory();
      // 获取Session
      Session session = sessionFactory.openSession();
      Customer customer = session.get(Customer.class,9);

      session.delete(customer);

      session.beginTransaction().commit();

      session.close();
  }
}
