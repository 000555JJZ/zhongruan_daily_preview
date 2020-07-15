# 声明 Java 的包名
namespace java com.test.thrift.spider
# 声明 Python 的包名
namespace py spider.api

# 定义服务，给出接口的名称
service SpiderService{
    # 发送短信，返回值-布尔值、参数-1=手机号 2-信息内容
    bool runSpider();
}