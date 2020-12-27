package com.geek.springcloud.service.impl;

import com.geek.springcloud.dao.IDeptDao;
import com.geek.springcloud.pojo.Dept;
import com.geek.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author geek
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

}
