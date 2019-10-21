package org.code4everything.demo.springboot.thrift.zklb.server.config;

import lombok.*;

import java.util.Objects;

/**
 * @author pantao
 * @since 2019/10/18
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ThriftProperty {

    @NonNull
    private Integer port;

    private Integer minThread;

    private Integer maxThread;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThriftProperty that = (ThriftProperty) o;
        return port.equals(that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port);
    }
}
