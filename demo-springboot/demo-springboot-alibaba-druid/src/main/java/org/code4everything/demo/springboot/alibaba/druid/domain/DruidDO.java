package org.code4everything.demo.springboot.alibaba.druid.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.code4everything.boot.base.bean.BaseBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author pantao
 * @since 2019/11/21
 */
@Data
@Entity(name = "druid")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DruidDO implements BaseBean {

    @Id
    @GeneratedValue
    private Long id;

    private String remark;

    private Date createdDate;
}
