package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Score
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/27 11:12
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private String scoNo;
    private String stuNo;
    private String couNo;
    private long score;
    private Student student;
}
