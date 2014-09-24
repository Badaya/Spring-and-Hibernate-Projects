package com.sample.dao.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.dao.api.jpa.OnRampJpaRepository;
import com.sample.onramp.model.UserEntity;

@MappedSuperclass
@NamedQueries({
@NamedQuery(
        name = "UserEntity.getUserDetailById",
        query = "select user \n" +
                " from UserEntity user\n" +
        		" where user.salesForceId = :id ")
		}
)
public interface UserRepository extends OnRampJpaRepository<UserEntity, String>{
	
    UserEntity getUserDetailById(@Param("id") String userId);
    
    @Query("select us from UserEntity us \n" +
           " where us.region = :region and \n" +
           " us.salesForceId <> :userId  order by us.firstName, us.lastName")
    List<UserEntity> getAllUsersByRegion(@Param("region") String region, @Param("userId") String userId);

    @Query("select us from UserEntity us \n" +
            " where us.salesForceId <> :userId order by us.firstName, us.lastName")
     List<UserEntity> getAllUser( @Param("userId") String userId);

    @Query("select us from UserEntity us \n" +
            " order by us.firstName")
     List<UserEntity> getAllUser();

}
