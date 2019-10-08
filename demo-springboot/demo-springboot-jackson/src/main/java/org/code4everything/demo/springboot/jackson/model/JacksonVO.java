package org.code4everything.demo.springboot.jackson.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.code4everything.boot.base.bean.BaseBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Data
@ToString
@JsonAppend
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JacksonVO implements BaseBean, Serializable {

    private static final long serialVersionUID = -8377871484806581193L;

    @JsonIgnore
    private String ignore;

    private Date dateDefault;

    @JsonAlias("date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date dateCustom;
}
