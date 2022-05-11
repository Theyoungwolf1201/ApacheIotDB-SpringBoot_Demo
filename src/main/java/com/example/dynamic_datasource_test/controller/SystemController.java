package com.example.dynamic_datasource_test.controller;

import com.example.dynamic_datasource_test.dao.MySystemDao;
import com.example.dynamic_datasource_test.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/09 08:50
 **/

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping("read4IoTDB")
    public List<MySystemDao> read4IoTDB () throws Exception {
        return systemService.read4IoTDB();
    }
}
