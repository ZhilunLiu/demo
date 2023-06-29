package com.charles.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.charles.demo.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByName(String name);
    UserEntity findFirstById(Long Id);

    List<UserEntity> findAll();

    @Query(value = "select * from user where name like ?1", nativeQuery = true)
    List<UserEntity> fuzzyQueryByName(String userName);
}
