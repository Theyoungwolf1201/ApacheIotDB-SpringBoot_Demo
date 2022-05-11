package com.example.dynamic_datasource_test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamic_datasource_test.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/09 16:33
 **/

@Service
@DS("slave_3")//使用数据库slave_3:IoTDB
public class SelectServiceImpl implements SelectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List ShowStorageGroup(){
        List list = jdbcTemplate.queryForList("show storage group");
        return list;
    }

    @Override
    public List ShowTimeSeries(){
        List list = jdbcTemplate.queryForList("show timeseries root.cdWater.cdLiquid.FK.FK000006");
        return list;
    }

    @Override
    public List ShowDevices(){
        List list = jdbcTemplate.queryForList("show devices");
        return list;
    }

    @Override
    public List ShowSchemaTemplate(){
        List list = jdbcTemplate.queryForList("show schema templates");
        return list;
    }
}
