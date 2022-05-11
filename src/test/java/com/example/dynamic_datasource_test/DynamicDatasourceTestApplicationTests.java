package com.example.dynamic_datasource_test;

import com.example.dynamic_datasource_test.dao.MySystemDao;
import com.example.dynamic_datasource_test.service.SystemService;
import com.example.dynamic_datasource_test.service.UserService;
import com.example.dynamic_datasource_test.util.StampDate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DynamicDatasourceTestApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    SystemService systemService;

    @Test
    void contextLoads() throws Exception {
        System.out.println("database:slave_1:"+userService.selectAll());
        System.out.println("database:slave_1:"+userService.selectAgeById());
        System.out.println("database:slave_2:"+userService.selectPassWordById());
        //System.out.println("database:slave_3:"+systemService.read4IoTDB());
        System.out.println("database:master:"+userService.selectAllFromMaster());

        List<MySystemDao> list = systemService.read4IoTDB();//从slave_3:IoTDB:root.demo.pc1表读数据
//        System.out.println(list);

//        StampDate stampDate = new StampDate();
//        System.out.println("开始向slave_1:Mysql:iotdb_integration:pc1表写数据,开始时间:"+stampDate.now());
//        systemService.write2Mysql(list);
//        System.out.println("写数据结束,本次写入数据"+list.size()+"条,结束时间："+stampDate.now());
    }

}
