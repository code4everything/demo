package org.code4everything.demo.springboot.alibaba.druid.controller;

import cn.hutool.core.util.StrUtil;
import org.code4everything.demo.springboot.alibaba.druid.domain.DruidDO;
import org.code4everything.demo.springboot.alibaba.druid.repository.DruidRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pantao
 * @since 2019/11/21
 */
@RestController
@RequestMapping("/api")
public class DruidController {

    private final DruidRepository druidRepository;

    public DruidController(DruidRepository druidRepository) {
        this.druidRepository = druidRepository;
    }

    @GetMapping("/druid/{id}")
    public DruidDO getById(@PathVariable Long id) {
        return druidRepository.getById(id);
    }

    @GetMapping("/druid")
    public List<DruidDO> listByRemark(String remark) {
        return druidRepository.getByRemarkLike(StrUtil.format("%{}%", remark));
    }
}
