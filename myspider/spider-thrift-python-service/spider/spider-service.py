from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from thrift.transport import TSocket, TTransport
from spider.douban2 import spider
from spider.api import SpiderService


class SpiderServiceHandler:
    def runSpider(self):
        spider();
        return True


if __name__ == '__main__':
    # 4. 创建 Thrift Server 提供的处理方法
    handler = SpiderServiceHandler()
    # from message.api import MessageService
    processor = SpiderService.Processor(handler)

    # 1. 创建 Thrift Server 的 ServerSocket
    serverSocket = TSocket.TServerSocket(host='127.0.0.1', port='9090')
    # 2. 创建 Thrift Server 的 Transport = 帧传输方式
    transportFactory = TTransport.TFramedTransportFactory()
    # 3. 创建 Thrift Server 的 Protocol  = 二进制传输协议
    protocolFactory = TBinaryProtocol.TBinaryProtocolFactory()

    # 5. 创建 Thrift Server, 指明如何处理(谁进行处理)、从哪来(监听哪个端口)、怎么传来(传输方式)、传输协议
    thriftServer = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)
    # 6. 启动 Thrfit Server, 等待客户端的访问
    print("Python Thrift Server start....")
    thriftServer.serve()
    print("Python Thrift Server exit")
