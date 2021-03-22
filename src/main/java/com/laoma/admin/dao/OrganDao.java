package com.laoma.admin.dao;

import com.laoma.admin.bean.Organ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OrganDao extends JpaRepository<Organ,Long>, JpaSpecificationExecutor<Organ> {

    Page<Organ> findAll(Pageable pageable);

    @Query("select o from Organ o where o.organname like ?1")

    Page<Organ> findByQuery(String query, Pageable pageable);

    Organ findOrganById(Long id);

    void deleteById(Long id);

}
