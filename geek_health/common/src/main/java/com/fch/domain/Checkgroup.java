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
public class Checkgroup implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private String mnemonics;

    private String sex;

    private String remark;

    private String attention;

    private List<Checkitem> checkitems;
}