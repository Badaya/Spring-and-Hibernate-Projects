package com.mfeastapp.dao.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mfeastapp.dao.api.jpa.MFeastAppJpaRepository;
import com.mfeastapp.model.UserTable;


@MappedSuperclass
public interface UserTableRepository extends
MFeastAppJpaRepository<UserTable, Long> {

	@Query("select ut from UserTable ut where ut.userName = :userName and ut.password = :password")
	UserTable validateUser(@Param("userName")String userName,@Param("password") String password);

	@Query("select ut from UserTable ut where ut.userId = :userId")
	UserTable getUserByUserId(@Param("userId") Long userId);

}
