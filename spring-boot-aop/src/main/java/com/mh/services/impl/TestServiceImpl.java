package com.mh.services.impl;

import cn.hutool.core.lang.Dict;
import com.mh.dao.TestDao;
import com.mh.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.services.impl
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 16:12
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public Dict select(String param) {
        testDao.insert(param);
        return Dict.create().set("select", "select * from dual");
    }
}
