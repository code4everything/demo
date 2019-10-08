package org.code4everything.demo.springboot.jackson.controller;

import com.google.common.collect.Lists;
import org.code4everything.demo.springboot.jackson.model.JacksonVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author pantao
 * @since 2019/10/8
 */
@RestController
@RequestMapping("/")
public class JacksonController {

    @GetMapping("/")
    public List<JacksonVO> jacksonVO() {
        JacksonVO jacksonVO = new JacksonVO();
        jacksonVO.setIgnore("ignore");
        jacksonVO.setDateDefault(new Date());

        JacksonVO another = jacksonVO.copyInto(new JacksonVO());
        another.setDateCustom(new Date());

        return Lists.newArrayList(jacksonVO, another);
    }
}
