package com.geek.springcloud.dao;

import com.geek.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author geek
 */
@Mapper
@Repository
public interface IDeptDao {

    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();

}
