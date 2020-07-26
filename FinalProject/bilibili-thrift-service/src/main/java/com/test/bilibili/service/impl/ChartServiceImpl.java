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

    @Override
    public ChartInfo getChartInfoPart9() throws TException {
        return chartDao.getChartInfoPart9();
    }

    @Override
    public ChartInfo getChartInfoPart10() throws TException {
        return chartDao.getChartInfoPart10();
    }

    @Override
    public ChartInfo getChartInfoPart11() throws TException {
        return chartDao.getChartInfoPart11();
    }

    @Override
    public ChartInfo getChartInfoPart12() throws TException {
        return chartDao.getChartInfoPart12();
    }

    @Override
    public ChartInfo getChartInfoPart13() throws TException {
        return chartDao.getChartInfoPart13();
    }

    @Override
    public ChartInfo getChartInfoPart14() throws TException {
        return chartDao.getChartInfoPart14();
    }

    @Override
    public ChartInfo getChartInfoPart15() throws TException {
        return chartDao.getChartInfoPart15();
    }

    @Override
    public ChartInfo getChartInfoPart16() throws TException {
        return chartDao.getChartInfoPart16();
    }
}
