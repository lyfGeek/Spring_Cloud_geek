package com.geek.springcloud.controller;

import com.geek.springcloud.pojo.Dept;
import com.geek.springcloud.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供 RESTFul 服务。
 *
 * @author geek
 */
@RestController
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);

        if (dept == null) {
            throw new RuntimeException("id => " + id + "。不存在该用户，或信息无法找到。");
        }

        return dept;
    }

    // 备选方案。
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("id => " + id + "。没有对应的信息。null。~@Hystrix。")
                .setDb_source("no this database in MySQL.");
    }

}
