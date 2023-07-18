package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkitem implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private String sex;

    private String age;

    private Float price;

    private String type;

    private String attention;

    private String remark;
}