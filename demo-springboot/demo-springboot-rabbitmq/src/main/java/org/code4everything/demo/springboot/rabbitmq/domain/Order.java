package org.code4everything.demo.springboot.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.code4everything.boot.base.bean.BaseBean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order implements BaseBean, Serializable {


    private static final long serialVersionUID = -4681751300262169031L;

    /**
     * 订单唯一编号
     */
    private String id;

    /**
     * 订单描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
