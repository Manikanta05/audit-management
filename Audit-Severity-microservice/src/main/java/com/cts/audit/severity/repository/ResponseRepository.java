package com.cts.audit.severity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.audit.severity.model.AuditResponseModel;

public interface ResponseRepository extends JpaRepository<AuditResponseModel, Integer> {

}
