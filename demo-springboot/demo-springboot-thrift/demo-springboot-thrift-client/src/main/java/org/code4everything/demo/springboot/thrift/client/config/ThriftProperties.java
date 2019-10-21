package org.code4everything.demo.springboot.thrift.client.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Thrift客户端配置
 *
 * @author pantao
 * @since 2019/10/16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("thrift")
public class ThriftProperties {

    private String host;

    private Integer port;
}
