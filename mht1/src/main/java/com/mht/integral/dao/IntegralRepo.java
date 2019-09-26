package com.mht.integral.dao;

import com.mht.integral.bean.Integral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface IntegralRepo extends JpaRepository<Integral,String>, JpaSpecificationExecutor<Integral>, Serializable {

    @Query(value = "select * from integral  where user_id = :id ORDER BY create_time desc",
            nativeQuery = true)
    Page<Integral> findMyIntegral(@Param(value = "id") String id, Pageable pageable);

    Integral findFirstByBusinessIdAndUserId(String businessId, String userId);

   List<Integral> findIntegralsByBusinessNameLikeAndAndUserId(String businessName, String userId);

   @Query(value = "select * from integral  where business_id = :id ORDER BY update_time desc" ,nativeQuery = true)
  Page<Integral> findIntegralsByBusinessId(@Param("id") String businessId, Pageable pageable);

}
