package com.fch.mapper;

import com.fch.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName AccountMapper
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:07
 * @Version 1.0
 */
@Repository
public interface AccountMapper {
    /**
     * 新增账户
     *
     * @param account 新增对象信息
     */
    @Insert("insert into practice_db.account (name, money) values (#{name}, #{money})")
    void add(Account account);

    /**
     * 删除账户
     *
     * @param id 删除账户的ID
     */
    @Delete("delete from practice_db.account where id = #{id}")
    void delete(Integer id);

    /**
     * 更新
     *
     * @param account 更新账户的信息
     */
    @Update("update practice_db.account set name = #{name}, money = #{money} where id = #{id}")
    void update(Account account);

    /**
     * 通过账户ID查找单个账户信息
     *
     * @param id 账户id
     * @return 返回账户对象
     */
    @Select("select id, name, money from practice_db.account where id = #{id}")
    Account findById(Integer id);

    /**
     * 查询所有账户信息
     *
     * @return 返回账户集合
     */
    @Select("select id, name, money from practice_db.account")
    List<Account> findAll();
}
