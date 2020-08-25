package com.gloryh.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Customer实体类
 *
 * @author 黄光辉
 * @since 2020/8/21
 **/
@Getter
@Setter
public class Customer {
    private Integer id;
    private String name;
    /**
     * 外键，采用集合方式映射 一对多
     */
    private Set<Orders> orders;

    /**
     * 重写toString方法，不加载Set<Orders>，防止出现相互调用形成死循环，造成内存溢出
     * @return
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
