package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public Boolean add(Dept dept) {
        deptDao.add(dept);
        return true;
    }

    @Override
    public List<Dept> getAllList() {

        return deptDao.getAllList();
    }

    @Override
    public Dept getById(String id) {
        return deptDao.getById(id);
    }
}
