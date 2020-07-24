package com.test.bilibili.dao.impl;

import com.test.bilibili.dao.ChartDao;
import com.test.bilibili.hdfs.HDFSUtils;
import com.test.thrift.bilibili.ChartInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChartDaoImpl implements ChartDao {
    @Override
    public ChartInfo getChartInfoPart1() {
        List<String> key = new ArrayList<>();
        List<Long> value = new ArrayList<>();
        key.add("123");
        key.add("456");
        value.add((long) 123);
        value.add((long) 456);
        return new ChartInfo(key,value);

    }

    @Override
    public ChartInfo getChartInfoPart2() {

        try {
            List<String> key = new ArrayList<>();
            List<Long> value = new ArrayList<>();

            HDFSUtils.getHDFSFileInfoToChart("hdfs://master:9000/output/wc/part-r-00000",key,value);
            ChartInfo chartInfo = new ChartInfo(key,value);
            return chartInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ChartInfo getChartInfoPart3() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart4() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart5() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart6() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart7() {
        return null;
    }

    @Override
    public ChartInfo getChartInfoPart8() {
        return null;
    }
}
