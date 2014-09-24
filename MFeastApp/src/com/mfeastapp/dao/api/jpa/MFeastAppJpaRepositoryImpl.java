package com.mfeastapp.dao.api.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class MFeastAppJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MFeastAppJpaRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public MFeastAppJpaRepositoryImpl(final Class<T> domainClass, final EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
    }

    @Override
    public T getReference(final ID id) {
        return entityManager.getReference(domainClass, id);
    }

}
