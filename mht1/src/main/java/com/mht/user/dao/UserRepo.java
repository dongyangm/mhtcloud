package com.mht.user.dao;

import com.mht.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserRepo extends JpaRepository<User,String>, JpaSpecificationExecutor<User>, Serializable {

    User findByAccount(String account);

    User findByAccountAndPassword(String account, String password);
}
