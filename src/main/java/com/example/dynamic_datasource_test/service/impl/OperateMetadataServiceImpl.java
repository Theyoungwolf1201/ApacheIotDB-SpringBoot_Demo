package com.example.dynamic_datasource_test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamic_datasource_test.service.OperateMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @program:dynamic_datasource_test
 * @description Apache IoTDB数据库操作Demo-元数据操作
 * @author:ZhaoWeihao
 * @create:2022/05/09 15:37
 **/

@Service
@DS("slave_3")//使用数据库slave_3:IoTDB
public class OperateMetadataServiceImpl implements OperateMetadataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void CreateStorageGroup(){
        jdbcTemplate.execute("set storage group to root.cdWater");
    }

    @Override
    public void DeleteStorageGroup(){
        jdbcTemplate.execute("DELETE STORAGE GROUP root.cdWater");
    }

    @Override
    public void CreateTimeSeries(){
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.record_date WITH datatype=TEXT,encoding=PLAIN");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.liquid with datatype=DOUBLE,encoding=RLE");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.error with datatype=TEXT,encoding=PLAIN");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.upper_water_level with datatype=DOUBLE,encoding=PLAIN");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.lower_water_level with datatype=DOUBLE,encoding=PLAIN");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.vp with datatype=TEXT,encoding=PLAIN");
        jdbcTemplate.execute("create timeseries root.cdWater.cdLiquid.FK.FK000006.to_delete with datatype=INT32,encoding=RLE");
    }

    @Override
    public void DeleteTimeSeries(){
        jdbcTemplate.execute("delete timeseries root.cdWater.cdLiquid.FK.FK000006.to_delete");
    }

    @Override
    public void CreateSchemaTemplate(){
        jdbcTemplate.execute("create schema template Pressure_YL000000(liquid DOUBLE encoding=RLE, record_date TEXT encoding=PLAIN, error TEXT encoding=PLAIN, upper_water_level DOUBLE encoding=PLAIN, lower_water_level DOUBLE encoding=PLAIN, vp TEXT encoding=PLAIN)");
    }

    @Override
    public void setSchemaTemplate(){
        jdbcTemplate.execute("set schema template Pressure_YL000000 to root.cdWater.cdPressure.SY.YL000001");
    }

    @Override
    public void useSchemaTemplate(){
        jdbcTemplate.execute("create timeseries of schema template on root.cdWater.cdPressure.SY.YL000001");
    }

    @Override
    public void UnsetSchemaTemplate(){
        jdbcTemplate.execute("unset schema template Pressure_YL000000 from root.cdWater.cdPressure.SY.YL000001");
    }

    @Override
    public void DropSchemaTemplate(){
        jdbcTemplate.execute("drop schema template cdLiquid_FK000000");
    }
}
