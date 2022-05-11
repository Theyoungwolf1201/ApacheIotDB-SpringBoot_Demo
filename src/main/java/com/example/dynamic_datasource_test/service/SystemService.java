package com.example.dynamic_datasource_test.service;

import com.example.dynamic_datasource_test.dao.MySystemDao;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/07 09:47
 **/

public interface SystemService {

    //从slave_3:IoTDB:root.demo.pc1表读数据，返回List<MySystemDao>
    List<MySystemDao> read4IoTDB() throws Exception;

    //向slave_1:Mysql:iotdb_integration:pc1表写数据
    void write2Mysql(List<MySystemDao> list);
}
