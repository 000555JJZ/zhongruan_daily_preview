package com.test.bilibili.util;

import com.test.thrift.bilibili.ChartInfo;
import com.test.thrift.bilibili.dto.ChartDTO;
import org.springframework.beans.BeanUtils;

public class ConvertDTO {

    public static ChartDTO toChartDTO(ChartInfo chartInfo){
        ChartDTO chartDTO = new ChartDTO();
        BeanUtils.copyProperties(chartInfo,chartDTO);
        return chartDTO;
    }
}
