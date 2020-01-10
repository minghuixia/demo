package com.mh.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.entity
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/3 11:02
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Data
@Entity
public class Visitor implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private  long  times;
    @Column(nullable = false)
    private  String  ip;
}
