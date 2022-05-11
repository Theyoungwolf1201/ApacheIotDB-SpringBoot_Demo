package com.example.dynamic_datasource_test.dao;

import lombok.Data;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/09 17:44
 **/

@Data
public class CDLiquidDao {
    String record_date;
    Double liquid;
    String error;
    Double upper_water_level;
    Double lower_water_level;
    String vp;
    int to_delete;
}
