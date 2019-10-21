package org.code4everything.demo.springboot.thrift.zklb.client.thrift;

import org.code4everything.demo.springboot.thrift.common.ThriftService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.thrift.transport.TSocket;

/**
 * @author pantao
 * @since 2019/10/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransClientPair {

    TSocket trans;

    ThriftService.Client client;
}
