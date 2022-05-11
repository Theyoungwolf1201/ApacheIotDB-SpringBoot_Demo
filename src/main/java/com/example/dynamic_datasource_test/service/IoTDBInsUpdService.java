package com.example.dynamic_datasource_test.service;

import com.example.dynamic_datasource_test.dao.CDLiquidDao;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description Apache IoTDB数据库操作Demo-Insert、Update操作
 * @author:ZhaoWeihao
 * @create:2022/05/09 17:34
 **/

public interface IoTDBInsUpdService {

    /**
     * TODO:Test
     * @description 将从PLC中读取的数据插入root.cdWater.cdLiquid.FK000006
     * @param list,tableName
     * @return
     * @throws
     */
    void Write2IotDB(List<CDLiquidDao> list);

    /**
     * TODO:Test
     * @description 从root.cdWater.cdLiquid.FK000006中删除满足条件的数据
     * @param
     * @return
     * @throws
     */
    void Delete4IoTDB(String column,String value);
}
