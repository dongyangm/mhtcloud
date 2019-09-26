package com.mht.sprcification.dao;

import com.mht.sprcification.bean.GoodSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface SpecificationRepo extends JpaRepository<GoodSpecification,String>, JpaSpecificationExecutor<GoodSpecification>, Serializable {

    List<GoodSpecification> findByGoodId(String goodId);

    void  deleteByGoodId(String goodId);
}
