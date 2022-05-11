package com.example.dynamic_datasource_test.dao;

import lombok.Data;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/07 09:44
 **/

@Data
public class MySystemDao {
    String  memoryUsage;
    String cpuUsage;
    String diskUsage;
    String time;
}
