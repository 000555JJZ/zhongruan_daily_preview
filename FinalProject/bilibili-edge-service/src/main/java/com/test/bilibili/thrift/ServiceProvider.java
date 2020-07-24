package com.test.bilibili.thrift;

import com.test.thrift.bilibili.ChartService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {
    @Value("${thrift.bilibili.ip}")
    private String serverIp;

    @Value("${thrift.bilibili.port}")
    private int serverPort;

    public ChartService.Client getChartService(){
        TSocket socket = new TSocket(serverIp, serverPort, 300000);
        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        TServiceClient result =  new ChartService.Client(protocol);

        return (ChartService.Client)result;

    }


}