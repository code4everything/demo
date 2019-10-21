package org.code4everything.demo.springboot.thrift.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Thrift服务端配置
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

    private Integer port;

    private Integer minThread;

    private Integer maxThread;
}
