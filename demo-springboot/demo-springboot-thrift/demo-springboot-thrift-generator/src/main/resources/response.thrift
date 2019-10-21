namespace java org.code4everything.demo.springboot.thrift.common

struct ThriftResponse {
    1: bool successful,
    2: i32 code,
    3: list<string> result
}

