package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public Dept getById(String id);
    public List<Dept> getAllList();
    public void add(Dept dept);
}
