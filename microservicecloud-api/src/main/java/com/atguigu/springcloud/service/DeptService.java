package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Boolean add(Dept dept);

    @RequestMapping(value="/dept/getAllList",method = RequestMethod.GET)
    public List<Dept> getAllList();

    @RequestMapping(value="/dept/getById/{id}",method = RequestMethod.GET)
    public Dept getById(@PathVariable("id") String id);
}
