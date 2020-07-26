package com.test.bilibili.util;

import com.test.thrift.bilibili.ChartInfoRadar2D;
import com.test.thrift.bilibili.dto.ChartRadar2DDTO;
import org.springframework.beans.BeanUtils;

public class ConvertRadar2DDTO {
    public static ChartRadar2DDTO toChartRadarDTO(ChartInfoRadar2D chartInfoRadar2D){
        ChartRadar2DDTO chartRadar2DDTO = new ChartRadar2DDTO();
        BeanUtils.copyProperties(chartInfoRadar2D, chartRadar2DDTO);
        return chartRadar2DDTO;
    }
}
