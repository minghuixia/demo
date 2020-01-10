package com.mh.repository;

import com.mh.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.entity.com.mh.repository
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 11:04
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
    Visitor findByIp(String ip);
}
