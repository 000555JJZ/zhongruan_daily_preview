package com.test.bilibili.service.impl;

import com.test.bilibili.dao.ChartDao;
import com.test.thrift.bilibili.ChartInfo;
import com.test.thrift.bilibili.ChartService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChartServiceImpl implements ChartService.Iface {
    @Resource
    private ChartDao chartDao;

    @Override
    public ChartInfo getChartInfoPart1() throws TException {
        return chartDao.getChartInfoPart1();
    }

    @Override
    public ChartInfo getChartInfoPart2() throws TException {
        return chartDao.getChartInfoPart2();
    }

    @Override
    public ChartInfo getChartInfoPart3() throws TException {
        return chartDao.getChartInfoPart3();
    }

    @Override
    public ChartInfo getChartInfoPart4() throws TException {
        return chartDao.getChartInfoPart4();
    }

    @Override
    public ChartInfo getChartInfoPart5() throws TException {
        return chartDao.getChartInfoPart5();
    }

    @Override
    public ChartInfo getChartInfoPart6() throws TException {
        return chartDao.getChartInfoPart6();
    }

    @Override
    public ChartInfo getChartInfoPart7() throws TException {
        return chartDao.getChartInfoPart7();
    }

    @Override
    public ChartInfo getChartInfoPart8() throws TException {
        return chartDao.getChartInfoPart8();
    }
}
