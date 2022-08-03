package com.cts.audit.severity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.audit.severity.model.AuditRequestModel;

public interface RequestRepository extends JpaRepository<AuditRequestModel, Integer> {

}
