namespace java com.test.thrift.bilibili

struct ChartInfo {
    1:list<string> key,
    2:list<i64> value
}

service ChartService {
    ChartInfo getChartInfoPart1()
    ChartInfo getChartInfoPart2()
    ChartInfo getChartInfoPart3()
    ChartInfo getChartInfoPart4()
    ChartInfo getChartInfoPart5()
    ChartInfo getChartInfoPart6()
    ChartInfo getChartInfoPart7()
    ChartInfo getChartInfoPart8()
    ChartInfo getChartInfoPart9()
    ChartInfo getChartInfoPart10()
    ChartInfo getChartInfoPart11()
    ChartInfo getChartInfoPart12()
    ChartInfo getChartInfoPart13()
    ChartInfo getChartInfoPart14()
    ChartInfo getChartInfoPart15()
    ChartInfo getChartInfoPart16()
}
struct ChartInfoRadar2D {
    1:list<string> key,
    2:list<list<i64>> value
}

service ChartServiceRadar2D {
    ChartInfoRadar2D getChartInfoRadar2DPart1()
    ChartInfoRadar2D getChartInfoRadar2DPart2()
    ChartInfoRadar2D getChartInfoRadar2DPart3()
    ChartInfoRadar2D getChartInfoRadar2DPart4()
    ChartInfoRadar2D getChartInfoRadar2DByStringPart1(1:string key)
    ChartInfoRadar2D getChartInfoRadar2DByStringPart2(1:string key)
}

struct ChartInfoRelation {
    1:list<string> key,
    2:list<string> value,
    3:list<i32> category,
    4:list<string> source,
    5:list<string> target
}

service ChartServiceRelation {
    ChartInfoRelation getChartInfoRelationPart1()
    ChartInfoRelation getChartInfoRelationPart2()
    ChartInfoRelation getChartInfoRelationPart3()
    ChartInfoRelation getChartInfoRelationPart4()
    ChartInfoRelation getChartInfoRelationByStringPart1(1:string key)
    ChartInfoRelation getChartInfoRelationByStringPart2(1:string key)

}


