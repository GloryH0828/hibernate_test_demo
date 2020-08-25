package com.gloryh.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Orders实体类
 *
 * @author 黄光辉
 * @since 2020/8/21
 **/
@Getter
@Setter
public class Orders {
    private Integer id;
    private String name;
    /**
     * 外键   多对一，映射customer
     */
    private Customer customer;

    /**
     * 重写toString方法,不加载Customer，防止出现相互调用形成死循环，造成内存溢出
     * @return
     */
    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
