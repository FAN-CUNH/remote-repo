package com.fch.prototype.prototype.deepcope;

import java.io.Serializable;

/**
 * @packageName com.fch.prototype.prototype.deepcope
 * @ClassName DeepCloneableTarget
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 17:16
 * @Version 1.0
 */
public class DeepCloneableTarget implements Serializable, Cloneable {
    private static final long serialVersionalUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
