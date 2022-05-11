package com.example.dynamic_datasource_test.service;

/**
 * @program:dynamic_datasource_test
 * @description Apache IoTDB数据库操作Demo-元数据操作
 * @author:ZhaoWeihao
 * @create:2022/05/09 13:33
 **/

public interface OperateMetadataService {

    /**
     * @description 在Apache IoTDB数据库中创建存储组cdWater.cdLiquid
     * @attention 当在Apache IoTDB数据库中创建了一个存储组后，该存储组的父子节点都不允许再设置存储组。例：创建cdWater.cdLiquid后不允许再创建cdWater.cdLiquid.northChangDao
     * @param
     * @return
     * @throws
     */
    void CreateStorageGroup();

    /**
     * TODO:待测
     * @description 在Apache IoTDB数据库中删除已创建的存储组cdWater
     * @attention 在删除存储组cdWater.cdLiquid的过程中，该存储组中的数据也会被删除
     * @param
     * @return
     * @throws
     */
    void DeleteStorageGroup();

    /**
     * @description 在Apache IoTDB数据库中已创建的存储组cdWater下创建节点cdLiquid.FK，并在该节点下创建设备FK000006及其时间序列：
     * record_date(datetime)、liquid(double(255,5))、error(varchar(255))、upper_water_level(double(255,5))、lower_water_level(double(255,5))、vp(varchar(255))、to_delete(int)
     * @attention
     * @param
     * @return
     * @throws
     */
    void CreateTimeSeries();

    /**
     * TODO:待测
     * @description 从Apache IoTDB数据库中已创建的存储组root.cdWater中的节点cdLiquid.FK下的设备FK000006内删除时间序列：to_delete
     * @attention
     * @param
     * @return
     * @throws
     */
    void DeleteTimeSeries();

    /**
     * @description 在Apache IoTDB数据库中创建元数据模板
     * @attention 元数据模板功能:实现同类型不同实体的物理量元数据共享，减少元数据内存占用，同时简化同类型实体的管理。
     * @param
     * @return
     * @throws
     */
    void CreateSchemaTemplate();

    /**
     * 将元数据模版挂载在树形数据模式的任意节点上，表示该节点下的所有实体具有相同的物理量集合。
     * @description 在Apache IoTDB数据库中已创建的存储组root.cdWater下的节点cdPressure.SY挂载元数据模板Pressure_YL000000
     * @attention 为了更好地适配未来版本的更新及各模块的协作，官方强烈建议将模板设置在存储组及存储组下层的节点中
     * 在插入数据之前，模板定义的时间序列不会被创建。可以使用如下SQL语句在插入数据前创建时间序列：create timeseries of schema template on root.cdWater.cdLiquid
     * @param
     * @return
     * @throws
     */
    void setSchemaTemplate();

    /**
     * @description 在Apache IoTDB数据库中已挂载模板的root.cdWater.cdPressure.SY.YL000001下，使用该模板创建时间序列
     * @param
     * @return
     * @throws
     */
    void useSchemaTemplate();

    /**
     * TODO:元数据模板被用于创建时间序列后就卸载不了了？
     * Try1:
     * @description 在Apache IoTDB数据库中已创建的存储组cdWater.cdPressure.SY下卸载已挂载的元数据模板
     * @attention 目前不支持从曾经使用模板插入数据后（即使数据已被删除）的实体中卸载模板。
     * @param
     * @return
     * @throws
     */
    void UnsetSchemaTemplate();

    /**
     * TODO:Test
     * @description 在Apache IoTDB数据库中删除元数据模板
     * @attention 不支持删除已经挂载的模板-即删除元数据模板之前必须将该模板卸载
     * @param
     * @return
     * @throws
     */
    void DropSchemaTemplate();
}
