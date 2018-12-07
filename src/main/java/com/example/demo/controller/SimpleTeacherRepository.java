package com.example.demo.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author ： fjl
 * @date ： 2018/12/7/007 9:27
 */
@Repository
public interface SimpleTeacherRepository extends JpaRepository<Teacher, Integer> {

    /**
     * 保存用户信息
     *
     * @param entity
     * @return
     */
    @Override
    <S extends Teacher> S save(S entity);

    /**
     * 根据id查询用户信息
     *
     * @param integer
     * @return
     */
    @Override
    Optional<Teacher> findById(Integer integer);


    /**
     * 查询所有
     *
     * @param example
     * @param <S>
     * @return
     */
    @Override
    <S extends Teacher> List<S> findAll(Example<S> example);

    /**
     * 根据id删除
     *
     * @param integer
     */
    @Override
    void deleteById(Integer integer);

    @Query("select u.id,u.password,u.username from Teacher u where u.username like :#{#username}")
    List<Teacher> findByUsername(String username);
}
