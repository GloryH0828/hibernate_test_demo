package com.gloryh.test;

import com.gloryh.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 测试类
 *
 * @author 黄光辉
 * @since 2020/8/21
 */
public class Test {
  public static void main(String[] args) {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    System.out.println(configuration);
    // 获取SessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取Session
    Session session = sessionFactory.openSession();
    People people = new People();
    people.setName("李四");
    session.save(people);
    session.beginTransaction().commit();
    session.close();
  }
}
