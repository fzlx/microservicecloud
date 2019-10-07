package com.atguigu.springcloud.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private String deptno;
    private String dname;
    private String db_source;
}
