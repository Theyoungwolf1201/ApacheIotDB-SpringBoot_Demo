package com.example.dynamic_datasource_test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamic_datasource_test.dao.CDLiquidDao;
import com.example.dynamic_datasource_test.service.IoTDBInsUpdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/10 08:28
 **/

@Service
@DS("slave_3")
public class IoTDBInsUpdServiceImpl implements IoTDBInsUpdService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void Write2IotDB(List<CDLiquidDao> list){
        for (CDLiquidDao cdLiquidDao:list){
            jdbcTemplate.update("insert into cdWater.cdLiquid.FK000006  values ('"
                    + cdLiquidDao.getRecord_date() + "','"
                    + cdLiquidDao.getLiquid() + "','"
                    + cdLiquidDao.getError() + "','"
                    + cdLiquidDao.getUpper_water_level() + "','"
                    + cdLiquidDao.getLower_water_level() + "','"
                    + cdLiquidDao.getVp() + "','"
                    + cdLiquidDao.getTo_delete() + "')");
        }
    }

    @Override
    public void Delete4IoTDB(String column,String value){
        jdbcTemplate.execute("delete from cdWater.cdLiquid.FK000006 where "+column+"="+"'"+value+"'");
    }
}
