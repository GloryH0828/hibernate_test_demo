package com.gloryh.test;

import com.gloryh.entity.Customer;
import com.gloryh.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 一对多测试
 *
 * @author 黄光辉
 * @since 2020/8/21
 */
public class OneToManyTest {
  public static void main(String[] args) {
    OneToManyTest.selectOnlyOne();
  }


  public static void selectOnlyOne() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取sessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取session
    Session session = sessionFactory.openSession();

    // 返回查询结果(id=6)
    Orders orders = session.get(Orders.class, 8);
    // 打印结果,此时打印并无customer数据
    System.out.println(orders);
    // 关闭连接
    session.close();
  }

  public static void selectBoth() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取sessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取session
    Session session = sessionFactory.openSession();

    // 返回查询结果(id=6)
    Orders orders = session.get(Orders.class, 8);
    // 打印结果,此时打印对应customer数据
    System.out.println(orders.getCustomer());
    // 关闭连接
    session.close();
  }
  public static void selectCount() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取sessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取session
    Session session = sessionFactory.openSession();

    // 返回查询结果(id=6)
    Customer customer = session.get(Customer.class, 6);
    // 打印结果，此时打印对应Orders的数量
    System.out.println(customer.getOrders().size());
    // 关闭连接
    session.close();
  }


  public static void insert() {
    // 创建Configuration
    Configuration configuration = new Configuration().configure();
    // 获取sessionFactory
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    // 获取session
    Session session = sessionFactory.openSession();
    // 创建Customer对象
    Customer customer = new Customer();
    customer.setName("李四");
    // 创建Orders
    Orders orders = new Orders();
    orders.setName("订单2");
    // 建立关联关系
    orders.setCustomer(customer);

    // 保存
    session.save(customer);
    session.save(orders);

    // 提交事务
    session.beginTransaction().commit();

    // 关闭session
    session.close();
  }
}
