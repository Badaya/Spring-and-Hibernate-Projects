package com.sample.dao.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sample.dao.api.jpa.OnRampJpaRepository;
import com.sample.onramp.model.ContactDetails;
import com.sample.onramp.model.UserEntity;


public interface ContactRepository  extends OnRampJpaRepository<ContactDetails, String> {
	
}
