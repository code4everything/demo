package org.code4everything.demo.springboot.alibaba.druid;

import cn.hutool.core.util.RandomUtil;
import org.code4everything.demo.springboot.alibaba.druid.domain.DruidDO;
import org.code4everything.demo.springboot.alibaba.druid.repository.DruidRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pantao
 * @since 2019/11/21
 */
@EnableWebMvc
@SpringBootApplication
public class DemoSpringbootAlibabaDruidApplication {

    private final DruidRepository druidRepository;

    public DemoSpringbootAlibabaDruidApplication(DruidRepository druidRepository) {
        this.druidRepository = druidRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootAlibabaDruidApplication.class, args);
    }

    @PostConstruct
    public void init() {
        int loop = 100;
        Date date = new Date();
        List<DruidDO> list = new ArrayList<>(loop);
        for (int i = 0; i < loop; i++) {
            list.add(new DruidDO().setCreatedDate(date).setRemark(RandomUtil.randomString(100)));
        }
        druidRepository.saveAll(list);
    }
}
