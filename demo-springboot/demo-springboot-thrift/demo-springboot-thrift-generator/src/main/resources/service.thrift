include "request.thrift"
include "response.thrift"

namespace java org.code4everything.demo.springboot.thrift.common

service ThriftService {

    void test(),

    response.ThriftResponse doRequest(1:request.ThriftRequest request)
}