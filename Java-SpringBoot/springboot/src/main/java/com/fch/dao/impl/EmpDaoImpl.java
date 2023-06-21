package com.fch.dao.impl;

import com.fch.dao.EmpDao;
import com.fch.pojo.Emp;
import com.fch.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @packageName com.fch.dao.impl
 * @ClassName EmpDaoImpl
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/3 17:49
 * @Version 1.0
 */
// @Component  将当前类交给工oC容器管理,成为工oC容器中的bean - 控制反转
@Repository // @Component 的衍生注解之一 用在 Dao层 实现控制反转
public class EmpDaoImpl implements EmpDao {
    /**
     * 获取员工列表数据
     *
     * @return 员工数据集合
     */
    @Override
    public List<Emp> listEmp() {

        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
