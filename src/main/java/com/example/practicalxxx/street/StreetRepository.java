package com.example.practicalxxx.street;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street,Integer> {
    @Query(value = "select * from streets s where s.name like %:name% and s.district_id=:distinctId",nativeQuery = true)
//    ,@Param("distinctId") int distinctId
    List<Street> findByInfo(@Param("name") String name,@Param("distinctId") int distinctId);

    @Query(value = "select * from streets s where s.name like %:name%",nativeQuery = true)
    List<Street> findByInfo(@Param("name") String name);
}
