package com.example.dynamic_datasource_test.service;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/06 16:43
 **/

public interface UserService {

    List selectAll();//取从库1数据

    List selectAgeById();//取从库1数据

    List selectPassWordById();//取从库2数据

    List selectALLFromSlave3();//取从库3数据

    List selectAllFromMaster();//取主库数据
}
