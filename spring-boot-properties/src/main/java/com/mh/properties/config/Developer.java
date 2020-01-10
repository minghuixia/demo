package com.mh.properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.properties.config
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2019/12/26 15:48
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Data
@ConfigurationProperties(prefix = "developer")
@Component
public class Developer {
    private String name;
    private String qq;
    private Integer age;
}
