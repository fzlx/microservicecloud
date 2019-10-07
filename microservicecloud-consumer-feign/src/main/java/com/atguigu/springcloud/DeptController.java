package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("consumer/dept/add")
    public Boolean add(@RequestBody Dept dept){
         return deptService.add(dept);
    }

    @RequestMapping("consumer/dept/getById/{id}")
    public Dept getById(@PathVariable String id){
        return deptService.getById(id);
    }

    @RequestMapping("consumer/dept/getAllList")
    public List<Dept> getAllList(){
        return deptService.getAllList();
    }
}
