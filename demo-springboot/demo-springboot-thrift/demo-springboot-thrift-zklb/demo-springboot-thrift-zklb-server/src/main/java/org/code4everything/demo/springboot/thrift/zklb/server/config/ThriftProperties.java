package org.code4everything.demo.springboot.thrift.zklb.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author pantao
 * @since 2019/10/18
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("thrift")
public class ThriftProperties {

    private List<ThriftProperty> services;
}

