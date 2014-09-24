package com.mfeastapp.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mfeastapp.dao.api.jpa.MFeastAppJpaRepository;
import com.mfeastapp.model.Survey;
import com.mfeastapp.model.UserTable;

public interface SurveyRepository extends MFeastAppJpaRepository<Survey, String> {
	
@Query("select su from Survey su")
List<Survey> getsurveydetails();

}
