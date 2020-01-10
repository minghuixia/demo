package com.mh.dao.impl;

import com.mh.dao.TestDao;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.dao.impl
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 16:52
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Component
public class TestDaoImpl implements TestDao {
    @Override
    public Long insert(String param) {
        return Long.parseLong(param);
    }
}
