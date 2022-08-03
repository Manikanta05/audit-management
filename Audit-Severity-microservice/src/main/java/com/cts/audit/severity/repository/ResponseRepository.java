package com.cts.audit.severity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.audit.severity.model.AuditResponseModel;

@Repository
public interface ResponseRepository extends JpaRepository<AuditResponseModel, Integer> {

}
