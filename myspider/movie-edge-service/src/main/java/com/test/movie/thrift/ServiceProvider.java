package com.test.movie.thrift;

import com.test.thrift.spider.SpiderService;
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
    @Value("${thrift.spider.ip}")
    private String spiderIp;

    @Value("${thrift.spider.port}")
    private int spiderPort;

    public SpiderService.Client getSpiderService(){
        TSocket socket = new TSocket(spiderIp, spiderPort, 300000);
        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        TServiceClient result = new SpiderService.Client(protocol);
        return (SpiderService.Client)result;
    }
}
