package com.test.bilibili.thrift;

import com.test.thrift.bilibili.ChartService;
import com.test.thrift.bilibili.ChartServiceRadar2D;
import com.test.thrift.bilibili.ChartServiceRelation;
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

    @Value("${thrift.bilibili.radar.ip}")
    private String radarServerIp;

    @Value("${thrift.bilibili.radar.port}")
    private int radarServerPort;

    @Value("${thrift.bilibili.relation.ip}")
    private String relationServerIp;

    @Value("${thrift.bilibili.relation.port}")
    private int relationServerPort;

    private enum ServiceType{
        CHART,
        RADAR_CHART,
        RELATION_CHART
    }

    public <T> T getService(String ip, int port, ServiceType serverType){
        TSocket socket = new TSocket(ip, port, 300000);
        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        TServiceClient result = null;
        switch (serverType){
            case CHART:
                result = new ChartService.Client(protocol);
                break;
            case RADAR_CHART:
                result = new ChartServiceRadar2D.Client(protocol);
                break;
            case RELATION_CHART:
                result = new ChartServiceRelation.Client(protocol);
                break;
        }

        return (T)result;
    }

    public ChartService.Client getChartService(){

        return  getService(serverIp, serverPort,ServiceType.CHART);
    }


    public ChartServiceRadar2D.Client getRadarChartService(){
        return  getService(radarServerIp,radarServerPort,ServiceType.RADAR_CHART);
    }

    public ChartServiceRelation.Client getRelationChartService(){
        return  getService(relationServerIp,relationServerPort,ServiceType.RELATION_CHART);
    }

}