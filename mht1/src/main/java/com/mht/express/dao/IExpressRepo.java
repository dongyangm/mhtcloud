package com.mht.express.dao;

import com.mht.express.bean.Express;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface IExpressRepo extends JpaRepository<Express,String>, JpaSpecificationExecutor<Express>, Serializable {
}
