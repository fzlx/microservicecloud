package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.Dept;
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
    RestTemplate restTemplate;
    public static final String PREFIX_URL="http://MICROSERVICECLOUD-DEPT";

    @RequestMapping("consumer/dept/add")
    public Boolean add(@RequestBody Dept dept){
         return restTemplate.getForObject(PREFIX_URL+"/dept/add",Boolean.class);
    }

    @RequestMapping("consumer/dept/getById/{id}")
    public Dept getById(@PathVariable String id){
        System.out.println("---------------->");
        return restTemplate.getForObject(PREFIX_URL+"/dept/getById/"+id,Dept.class,id);
    }

    @RequestMapping("consumer/dept/getAllList")
    public List<Dept> getAllList(){
        return restTemplate.getForObject(PREFIX_URL+"/dept/getAllList",List.class);
    }
}
