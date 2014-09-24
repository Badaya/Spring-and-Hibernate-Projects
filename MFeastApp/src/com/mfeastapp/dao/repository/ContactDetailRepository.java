package com.mfeastapp.dao.repository;





import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mfeastapp.dao.api.jpa.MFeastAppJpaRepository;
import com.mfeastapp.model.ContactDetail;
import com.mfeastapp.model.UserTable;
import java.sql.Blob;

@MappedSuperclass
public interface ContactDetailRepository extends MFeastAppJpaRepository<ContactDetail, Long> {
	@Query("select cd from ContactDetail cd where cd.userId= :userId")
	ContactDetail getContactByUserId(@Param("userId") UserTable userId);
	
	@Query("select cd from ContactDetail cd where cd.userId=:userId")
	ContactDetail getDisplayPic(@Param("userId") UserTable userId);

}
