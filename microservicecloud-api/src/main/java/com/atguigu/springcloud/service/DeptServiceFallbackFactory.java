package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cglib.proxy.Factory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {

    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Boolean add(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> getAllList() {
                return null;
            }

            @Override
            public Dept getById(String id) {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDb_source("no this database in MySQL");
            }
        };
    }
}
