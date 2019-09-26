package com.mht.interecord.dao;

import com.mht.interecord.bean.IntegralRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface IntegralRecordRepo extends JpaRepository<IntegralRecord,String>, JpaSpecificationExecutor<String>, Serializable {

    @Query(value = "select * from integral_record where business_id = :id order by have_time desc", nativeQuery = true)
    Page<IntegralRecord> businessFindAllIntegralRecord(@Param("id") String businessId, Pageable pageable);

    @Query(value = "select * from integral_record where business_id = :id group by user_id order by have_time DESC",nativeQuery = true)
    Page<IntegralRecord> businessFindGroupByUserId(@Param(value = "id") String businessId, Pageable pageable);

    @Query(value = "select * from integral_record where business_id = :businessId and user_id = :userId order by have_time desc",nativeQuery = true)
    Page<IntegralRecord> findRecordsByBusinessIdAndUserId(@Param("businessId") String businessId, @Param("userId") String userId, Pageable pageable);

    @Query(value = "select * from integral_record where user_id = :id order by have_time desc",nativeQuery = true)
   Page<IntegralRecord> buyerFindAllRecord(@Param("id") String userId, Pageable pageable);

    @Query(value = "select * from integral_record where user_id = :userId group by business_id order by have_time desc",nativeQuery = true)
    List<IntegralRecord> buyerFindBusinessGroup(@Param(value = "userId") String userId, Pageable pageable);
}
