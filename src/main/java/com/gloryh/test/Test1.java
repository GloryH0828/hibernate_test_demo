package com.gloryh.test;

import com.gloryh.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 黄光辉
 * @since 2020/8/24
 */
public class Test1 {
  public static void main(String[] args) {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取SessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取Session
    Session session = sessionFactory.openSession();
    String hql = "from People";
    Query query = session.createQuery(hql);
    List<People> list = query.list();
    for (People people :list) {
      System.out.println(people);
    }
    session.beginTransaction().commit();
    session.close();
  }
}
