package org.code4everything.demo.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.code4everything.boot.base.bean.BaseBean;

/**
 * @author pantao
 * @since 2019/10/20
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserVO implements BaseBean {

    private String name;

    private Integer count;
}
