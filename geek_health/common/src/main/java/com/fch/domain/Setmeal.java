package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Setmeal implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private String mnemonics;

    private String sex;

    private String age;

    private Float price;

    private String remark;

    private String attention;

    private String img;

    // 体检套餐对应的检查组， 多对多关系
    private List<Checkgroup> checkgroups;
}