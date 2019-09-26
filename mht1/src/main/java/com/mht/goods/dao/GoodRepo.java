package com.mht.goods.dao;

import com.mht.goods.bean.Good;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public interface GoodRepo extends JpaRepository<Good,String>, JpaSpecificationExecutor<Good>, Serializable {

    @Query(value = "select * from good  where business_id = :id ORDER BY create_time desc",
            nativeQuery = true)
    Page<Good> findMyGoods(@Param(value = "id") String id, Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "update good set view_num= ?2 where id = ?1",nativeQuery = true)
    int updateViewNum(String id, int num);

    Page<Good> findAllByBusinessId(String id, Pageable pageable);

}
