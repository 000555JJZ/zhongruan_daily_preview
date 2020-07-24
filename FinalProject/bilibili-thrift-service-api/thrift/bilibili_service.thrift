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
}
