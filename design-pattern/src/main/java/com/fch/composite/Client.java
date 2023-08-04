package com.fch.composite;

import com.fch.composite.component.composite.College;
import com.fch.composite.component.composite.Department;
import com.fch.composite.component.OrganizationComponent;
import com.fch.composite.component.composite.University;

/**
 * @packageName com.fch.composite
 * @ClassName Client
 * @Description TODO 模拟客户端
 * @Author Fan-CUNH
 * @Date 2023/8/4 10:54
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 从大到小创建对象
        // 学校
        OrganizationComponent university = new University("清华大学", "世界顶级大学");

        // 学院
        OrganizationComponent computerCollege = new College("计算机学院", "清华大学王牌学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程系", "清华大学一流学院");

        // 系
        OrganizationComponent csat = new Department("计算机科学与技术", "清华大学王牌专业");
        OrganizationComponent software = new Department("软件工程", "清华大学一流专业");

        OrganizationComponent communicationEngineering = new Department("通信工程", "清华大学王牌专业");
        OrganizationComponent informationEngineering = new Department("信息工程", "清华大学王牌一流");

        // 将学院添加到学校
        university.add(computerCollege);
        university.add(infoEngineerCollege);

        // 将系添加到学院
        computerCollege.add(csat);
        computerCollege.add(software);

        infoEngineerCollege.add(communicationEngineering);
        infoEngineerCollege.add(informationEngineering);

        // 输出整个学校包含的学院以及系
        university.print();
        // 输出具体的某个学院
        computerCollege.print();
    }
}
