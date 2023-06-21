package com.fch.service.impl;

import com.fch.dao.EmpDao;
import com.fch.dao.impl.EmpDaoImpl;
import com.fch.pojo.Emp;
import com.fch.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName EmpServiceImpl
 * @Description 业务逻辑层
 * @Author CunHao Fan
 * @Date 2023/6/3 17:55
 * @Version 1.0
 */
// @Component  将当前类交给工oC容器管理,成为工oC容器中的bean - 控制反转
@Service // @Component 的衍生注解之一 用在 Service 层实现控制反转
public class EmpServiceImpl implements EmpService {
    /**
     * 调用 EmpDao
     */
    @Autowired
    private EmpDao empDao;

    /**
     * 获取员工列表数据
     *
     * @return 员工数据集合
     */
    @Override
    public List<Emp> empList() {

        //1. 调用 empDao 获取empList
        List<Emp> empList = empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job
        empList.forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
