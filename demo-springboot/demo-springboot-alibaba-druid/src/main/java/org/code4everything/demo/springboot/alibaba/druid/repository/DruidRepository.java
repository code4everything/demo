package org.code4everything.demo.springboot.alibaba.druid.repository;

import org.code4everything.demo.springboot.alibaba.druid.domain.DruidDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pantao
 * @since 2019/11/21
 */
@Repository
public interface DruidRepository extends JpaRepository<DruidDO, Long> {

    DruidDO getById(Long id);

    List<DruidDO> getByRemarkLike(String remark);
}
