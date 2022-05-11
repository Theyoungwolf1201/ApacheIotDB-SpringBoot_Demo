package com.example.dynamic_datasource_test.service;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description Apache IoTDB数据库操作Demo-查询操作
 * @author:ZhaoWeihao
 * @create:2022/05/09 13:11
 **/

public interface SelectService {

    /**
     * @description 查看Apache IoTDB数据库中root根节点下存在的存储组
     * @attention
     * @param
     * @return
     * @throws
     */
    List ShowStorageGroup();

    /**
     * @description 查看Apache IoTDB数据库中root.cdWater.cdLiquid.FK.FK000006下所有时间序列信息
     * @attention
     * @param
     * @return
     * @throws
     */
    List ShowTimeSeries();

    /**
     * @description 查看Apache IoTDB数据库中root根节点下存在的设备
     * @attention
     * @param
     * @return
     * @throws
     */
    List ShowDevices();

    /**
     * TODO:Test
     * @description 查看Apache IoTDB数据库中所有元数据模板
     * @attention
     * @param
     * @return
     * @throws
     */
    List ShowSchemaTemplate();
}
