package com.test.bilibili.thrift;

import com.test.thrift.bilibili.ChartService;
import com.test.thrift.bilibili.ChartServiceRadar2D;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class ThriftServer {

    @Value("${service.port}")
    private int servicePort;

    @Resource
    private ChartServiceRadar2D.Iface chartServiceRadar2D;

    @PostConstruct
    public  void startThriftServer(){
        TNonblockingServerSocket serverSocket = null;
        try {
            serverSocket = new TNonblockingServerSocket(servicePort);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        TFramedTransport.Factory transportFactory = new TFramedTransport.Factory();
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
        TProcessor processor = new ChartServiceRadar2D.Processor<>(chartServiceRadar2D);
        TNonblockingServer.Args args = new TNonblockingServer.Args(serverSocket);
        args.transportFactory(transportFactory);
        args.protocolFactory(protocolFactory);
        args.processor(processor);
        TServer server = new TNonblockingServer(args);
        System.out.println("ChartServiceRadar Thrift service starting......");
        server.serve();
        System.out.println("ChartServiceRadar Thrift service stoped");
    }
}
