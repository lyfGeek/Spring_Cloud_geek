package com.geek.springcloud.controller;

import com.geek.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @Autowired
    private RestTemplate restTemplate;
    // 提供多种便捷访问远程 http 服务的方法。简单的 RESTFul 服务模板。

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        //     @Nullable
        //     public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        //     @Nullable
        //     public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        //    @Nullable
        //    public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
