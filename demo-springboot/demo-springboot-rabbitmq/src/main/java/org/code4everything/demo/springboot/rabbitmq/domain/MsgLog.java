package org.code4everything.demo.springboot.rabbitmq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.code4everything.boot.base.bean.BaseBean;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MsgLog implements BaseBean, Serializable {

    private static final long serialVersionUID = 2183492500157907764L;

    /**
     * 消息唯一编号
     */
    private String id;

    /**
     * 消息内容
     */
    private String body;

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 投递状态：0投递中，1投递失败，2投递成功
     */
    private Character status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
