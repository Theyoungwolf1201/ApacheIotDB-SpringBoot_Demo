package com.example.dynamic_datasource_test.controller;

import com.example.dynamic_datasource_test.util.Opcua_Test;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:dynamic_datasource_test
 * @description
 * @author:ZhaoWeihao
 * @create:2022/05/18 10:47
 **/

@RestController
@RequestMapping("/OPC-UA")
public class OPCUAController {

    @RequestMapping("/read")
    public void read() throws Exception {
        Opcua_Test ocpua_test = new Opcua_Test();
        OpcUaClient client = ocpua_test.createClient();
        client.connect().get();
        ocpua_test.readNode(client);
    }
}
