package com.cts.audit.severity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.audit.severity.model.AuditDetailModel;

public interface DetailRepository extends JpaRepository<AuditDetailModel, Integer> {

}
