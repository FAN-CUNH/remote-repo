package com.fch.prototype.prototype.deepcope;

import java.io.*;

/**
 * @packageName com.fch.prototype.prototype.deepcope
 * @ClassName DeepPrototype
 * @Description TODO 实现序列化，克隆接口
 * @Author Fan-CUNH
 * @Date 2023/8/2 17:18
 * @Version 1.0
 */
public class DeepPrototype implements Serializable, Cloneable {
    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype() {
        super();
    }


    /**
     * 深拷贝 - 方式一 重写clone方法来实现深拷贝
     *
     * @return Obj
     * @throws CloneNotSupportedException 异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 调用父类的clone()方法 实现基本数据类型和string类型属性的克隆
        Object deep = super.clone();

        // 通过引用数据类型自己调用自己的clone()方法 完成自身克隆
        DeepPrototype deepPrototype = ((DeepPrototype) deep);
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deepPrototype;
    }

    /**
     * 深拷贝 - 方式二 通过对象序列化实现（推荐）
     *
     * @return Obj
     */
    public Object deepClone() {
        // 声明输入输出流对象
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            // 序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            // 序列化写出本类对象
            objectOutputStream.writeObject(this);

            // 反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert byteArrayOutputStream != null;
                byteArrayOutputStream.close();
                assert byteArrayInputStream != null;
                byteArrayInputStream.close();
                objectOutputStream.close();
                assert objectInputStream != null;
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
