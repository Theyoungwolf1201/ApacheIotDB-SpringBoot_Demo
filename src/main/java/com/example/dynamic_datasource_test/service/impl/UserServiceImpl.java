package com.example.dynamic_datasource_test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamic_datasource_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/06 16:46
 **/

@Service
@DS("slave")
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List selectAll() {
        return  jdbcTemplate.queryForList("select * from user");
    }

    @Override
    @DS("slave_1")
    public List selectAgeById() {
        return  jdbcTemplate.queryForList("select * from user where id = 1001");
    }

    @Override
    @DS("slave_2")
    public List selectPassWordById(){
        return jdbcTemplate.queryForList("select password from user where id<>1006");
    }

    @Override
    @DS("slave_3")
    public List selectALLFromSlave3(){
        return jdbcTemplate.queryForList("select * from root.demo.pc1");
    }

    @Override
    @DS("master")
    public List selectAllFromMaster(){
        return jdbcTemplate.queryForList("select * from user");
    }

}
