package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public Boolean add(Dept dept){
        deptService.add(dept);
        return true;
    }

    @RequestMapping(value="/dept/getAllList",method = RequestMethod.GET)
    public List<Dept> getAllList(){
         return deptService.getAllList();
    }

    //@HystrixCommand(fallbackMethod = "hystriCommand_getById")
    @RequestMapping(value="/dept/getById/{id}",method = RequestMethod.GET)
    public Dept getById(@PathVariable String id){
        if(id.equals("30001")){
            throw  new RuntimeException("id："+id+"不存在");
        }else{
            return deptService.getById(id);
        }

    }

    public Dept hystriCommand_getById(@PathVariable String id){
        return new Dept().setDname("该id： "+id+ "不存在");

    }
}
