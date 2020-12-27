package com.geek.springcloud.controller;

import com.geek.springcloud.pojo.Dept;
import com.geek.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供 RESTFul 服务。
 *
 * @author geek
 */
@RestController
public class DeptController {

    @Autowired
    private IDeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
//        return deptService.queryById(id);
        Dept dept = deptService.queryById(id);

        if (dept == null) {
            throw new RuntimeException("id => " + id + "。不存在该用户，或信息无法找到。");
        }

        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    // 注册进来的微服务，获取一些消息。
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获得微服务列表的清单。
        List<String> stringList = discoveryClient.getServices();
        System.out.println("stringList = " + stringList);
        // stringList = [springcloud-provider-dept]

        // 得到具体的微服务信息。
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println("instance = " + instance);// instance = org.springframework.cloud.netflix.eureka
            System.out.println(instance.getHost());// LAPTOP-0GJSKR6T
            System.out.println(instance.getUri());// http://LAPTOP-0GJSKR6T:8001
            System.out.println(instance.getInstanceId());// springcloud-provider-dept8001
            System.out.println(instance.getMetadata());// vlsi.utils.CompactHashMap@50e8c19e
            System.out.println(instance.getPort());// 8001
            System.out.println(instance.getScheme());// null
            System.out.println(instance.getServiceId());// SPRINGCLOUD-PROVIDER-DEPT
        }

        return this.discoveryClient;
        // {"discoveryClients":[{"services":["springcloud-provider-dept"],"order":0},{"services":[],"order":0}],"services":["springcloud-provider-dept"],"order":0}
    }

}
