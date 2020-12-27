package com.geek.springcloud.service;

import com.geek.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author geek
 */
public interface IDeptService {

    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();

}
