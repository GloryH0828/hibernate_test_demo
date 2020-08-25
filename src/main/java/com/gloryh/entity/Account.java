package com.gloryh.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Account实体类
 *
 * @author 黄光辉
 * @since 2020/8/21
 **/
@Getter
@Setter
public class Account {
    private Integer id;
    private String name;
    private Set<Course> courses;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
