package com.gloryh.test;

import com.gloryh.entity.Account;
import com.gloryh.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 多对多测试
 *
 * @author 黄光辉
 * @since 2020/8/21
 */
public class ManyToManyTest {
  public static void main(String[] args) {
    ManyToManyTest.creat();
  }


  /** 查询Course，加载对应Account 默认延迟加载开启(lazy="true") */
  public static void select1() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取SessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取Session
    Session session = sessionFactory.openSession();

    // 获取Course对象并打印
    Course course = session.get(Course.class, 2);

    System.out.println(course.getAccounts());
    //关闭连接
    session.close();
  }
  /** 创建多对多关系表 */
  public static void creat() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取SessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取Session
    Session session = sessionFactory.openSession();

    // 创建Course对象
    Course course = new Course();
    course.setName("Python");

    // 创建Account对象
    Account account = new Account();
    account.setName("李四");

    // 创建Course集合
    Set<Course> courses = new HashSet<>();
    courses.add(course);

    // 将Course集合赋值给Account
    account.setCourses(courses);

    // 保存
    session.save(account);
    session.save(course);

    // 提交事务
    session.beginTransaction().commit();

    // 关闭连接
    session.close();
  }
}
