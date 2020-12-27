package com.geek.springcloud.controller;

import com.geek.springcloud.pojo.Dept;
import com.geek.springcloud.service.IDeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author geek
 */
@RestController
public class DeptConsumerController {

    // 消费者不应该有 service 层。
    // RESTFul。
    // RestTemplate。直接调用方法。注册到 Spring 中。

    // Ribbon 实现时，这时地址应该是个变量。服务名。
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    // feign。
    @Autowired
    private IDeptClientService deptClientService = null;// null，没有实现类。

//    @Autowired
//    private RestTemplate restTemplate;
    // 提供多种便捷访问远程 http 服务的方法。简单的 RESTFul 服务模板。

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return this.deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.deptClientService.queryAll();
    }

}
