package com.example.dynamic_datasource_test.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamic_datasource_test.dao.MySystemDao;
import com.example.dynamic_datasource_test.service.SystemService;
import com.example.dynamic_datasource_test.util.StampDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/07 09:47
 **/

@Service
@DS("slave_3")
public class SystemServiceImpl implements SystemService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 从slave_3:IoTDB:root.demo.pc1表读数据，返回List<MySystemDao>
     * @param
     * @return List<MySystemDao>
     * @throws
     */
    @Override
    @DS("slave_3")
    public List<MySystemDao> read4IoTDB() throws Exception {
        List<MySystemDao> mySystemInfos_result = new ArrayList<>();
        List<Map<String, Object>> a = jdbcTemplate.queryForList("select * from root.demo.pc1 limit 10");

        System.out.println("read4IoTDB:本次数据读取条数："+a.size()+"条");

        Map<String, Object> b = new HashMap<>();
        MySystemDao mySystemDao = new MySystemDao();
        StampDate stampDate = new StampDate();
        if (a != null){
            for (int i=0;i<a.size();i++){
                b=a.get(i);
                mySystemDao.setTime(stampDate.stampToTime(String.valueOf(b.get("Time"))));
                mySystemDao.setDiskUsage(String.valueOf(b.get("root.demo.pc1.disk")));
                mySystemDao.setMemoryUsage(String.valueOf(b.get("root.demo.pc1.memory")));
                mySystemDao.setCpuUsage(String.valueOf(b.get("root.demo.pc1.cpu")));
                mySystemInfos_result.add(mySystemDao);
            }
        }
        return mySystemInfos_result;
    }

    /**
     * 向slave_1:Mysql:iotdb_integration:pc1表写数据，以此测试Mysql数据写入性能
     * @param list
     * @return
     * @throws
     */
    @Override
    @DS("slave_1")
    public void write2Mysql(List<MySystemDao> list){
        for (MySystemDao mySystemDao:list){
            jdbcTemplate.update("insert into pc1(timez,disk,memory,cpu) values ('"
                    + mySystemDao.getTime() + "','"
                    + mySystemDao.getDiskUsage() + "','"
                    + mySystemDao.getMemoryUsage() + "','"
                    + mySystemDao.getCpuUsage() + "')");
        }
    }

}
