package com.test.bilibili.util;

import com.test.thrift.bilibili.ChartInfo;
import com.test.thrift.bilibili.ChartInfoRelation;
import com.test.thrift.bilibili.dto.ChartDTO;
import com.test.thrift.bilibili.dto.ChartRelationDTO;
import org.springframework.beans.BeanUtils;

public class ConvertRelationDTO {

    public static ChartRelationDTO toChartRelationDTO(ChartInfoRelation chartInfoRelation){
        ChartRelationDTO chartRelationDTO = new ChartRelationDTO();
        BeanUtils.copyProperties(chartInfoRelation,chartRelationDTO);
        return chartRelationDTO;
    }
}
