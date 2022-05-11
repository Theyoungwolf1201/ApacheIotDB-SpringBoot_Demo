package com.example.dynamic_datasource_test.controller;

import com.example.dynamic_datasource_test.dao.CDLiquidDao;
import com.example.dynamic_datasource_test.service.IoTDBInsUpdService;
import com.example.dynamic_datasource_test.service.OperateMetadataService;
import com.example.dynamic_datasource_test.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/09 16:52
 **/

@RestController
@RequestMapping("/IoTDBFunctionDemonstration")
public class IoTDBFunctionDemonstrationController {

    @Autowired
    OperateMetadataService operateMetadataService;
    @Autowired
    SelectService selectService;
    @Autowired
    IoTDBInsUpdService ioTDBInsUpdService;

    @RequestMapping("/CreateStorageGroup")
    public void CreateStorageGroup(){
        operateMetadataService.CreateStorageGroup();
        System.out.println("存储组root.cdWater创建完成.");
    }

    @RequestMapping("/ShowStorageGroup")
    public List ShowStorageGroup(){
        List list = selectService.ShowStorageGroup();
        System.out.println("Apache IoTDB数据库中root根节点下存在的存储组:"+list);
        return list;
    }

    @RequestMapping("/CreateTimeSeries")
    public void CreateTimeSeries(){
        operateMetadataService.CreateTimeSeries();
        System.out.println("节点cdLiquid.FK、其该节点下设备FK000006及其时间序列已创建.");
    }

    @RequestMapping("/ShowTimeSeries")
    public List ShowTimeSeries(){
        List list = selectService.ShowTimeSeries();
        System.out.println("Apache IoTDB数据库中root.cdWater.cdLiquid.FK.FK000006下所有时间序列信息:"+list);
        return list;
    }

    @RequestMapping("/ShowDevices")
    public List ShowDevices(){
        List list = selectService.ShowDevices();
        System.out.println("Apache IoTDB数据库中root根节点下存在的设备:"+list);
        return list;
    }

    @RequestMapping("/CreateSchemaTemplate")
    public void CreateSchemaTemplate(){
        operateMetadataService.CreateSchemaTemplate();
        System.out.println("元数据模板cdLiquid_FK000000已创建.");
    }

    @RequestMapping("/ShowSchemaTemplate")
    public List ShowSchemaTemplate(){
        List list = selectService.ShowSchemaTemplate();
        System.out.println("Apache IoTDB数据库中所有元数据模板:"+list);
        return list;
    }

    @RequestMapping("/setSchemaTemplate")
    public void setSchemaTemplate(){
        operateMetadataService.setSchemaTemplate();
        System.out.println("元数据模板Pressure_YL000000已于存储组节点cdWater.cdPressure.SY下挂载.");
    }

    @RequestMapping("/useSchemaTemplate")
    public List useSchemaTemplate(){
        operateMetadataService.useSchemaTemplate();
        List list = selectService.ShowTimeSeries();
        System.out.println("设备root.cdWater.cdPressure.SY.YL000001已使用挂载于cdWater.cdPressure.SY下的元数据模板Pressure_YL000000创建对应时间序列.");
        System.out.println("当前root.cdWater存储组下时间序列为");
        return list;
    }

    @RequestMapping("/UnsetSchemaTemplate")
    public void UnsetSchemaTemplate(){
        operateMetadataService.UnsetSchemaTemplate();
        System.out.println("已卸载存储组cdWater.cdPressure.SY下挂载的元数据模板Pressure_YL000000.");
    }

    @RequestMapping("/DropSchemaTemplate")
    public void DropSchemaTemplate(){
        operateMetadataService.DropSchemaTemplate();
        System.out.println("已删除元数据模板cdLiquid_FK000000.");
    }

    @RequestMapping("/Write2IotDB")
    public void Write2IotDB(){
        List<CDLiquidDao> list = new ArrayList<>();

        ioTDBInsUpdService.Write2IotDB(list);
        System.out.println("已将数据写入root.cdWater.cdLiquid.FK.FK000006");
    }

    @RequestMapping("/Delete4IoTDB")
    public void Delete4IoTDB(){
        String column = "record_date";
        String value = "2022-05-10 13:07:20.156";
        ioTDBInsUpdService.Delete4IoTDB(column,value);
        System.out.println("已从root.cdWater.cdLiquid.FK.FK000006中删除"+column+"为"+value+"的数据");
    }

    @RequestMapping("/DeleteTimeSeries")
    public void DeleteTimeSeries(){
        operateMetadataService.DeleteTimeSeries();
        System.out.println("已删除cdWater.cdLiquid.FK000006中时间序列to_delete.");
    }

    @RequestMapping("/DeleteStorageGroup")
    public void DeleteStorageGroup(){
        operateMetadataService.DeleteStorageGroup();
        System.out.println("已删除存储组cdWater.cdLiquid.");
    }
}
