package com.geek.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept 实体类。
 * orm。类 表 关系映射。
 *
 * @author geek
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)// 链式写法。
public class Dept implements Serializable {

    /**
     * 主键。
     */
    private Long deptno;
    private String dname;

    /**
     * 这个数据是存在哪个数据库的字段。~微服务，一个服务对应一个数据库。同一个信息可能存在不同数据库。
     */
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }

    /*
    链式写法。
    Dept dept = new Dept();
    dept.setDeptno(11).setDname("ss").setDb_source("001");
     */
}
