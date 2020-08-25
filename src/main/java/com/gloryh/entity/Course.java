package com.gloryh.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Course实体类
 *
 * @author 黄光辉
 * @since 2020/8/21
 **/
@Getter
@Setter
public class Course {
    private Integer id;
    private String name;
    private Set<Account> accounts;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
