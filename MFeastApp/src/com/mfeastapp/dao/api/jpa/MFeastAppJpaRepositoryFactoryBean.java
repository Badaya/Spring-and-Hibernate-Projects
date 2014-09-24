package com.mfeastapp.dao.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 */
public class MFeastAppJpaRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
        return new StaplesJpaRepositoryFactory<T, ID>(entityManager);
    }


    private final static class StaplesJpaRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

        private final EntityManager entityManager;

        private StaplesJpaRepositoryFactory(final EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

        @Override
        protected Object getTargetRepository(final RepositoryMetadata metadata) {
            @SuppressWarnings("unchecked")
            final Class<T> domainClass = (Class<T>) metadata.getDomainType();

            return new MFeastAppJpaRepositoryImpl<T, ID>(domainClass, entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {
            return MFeastAppJpaRepository.class;
        }
    }
}