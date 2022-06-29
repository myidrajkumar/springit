package com.rajkumar.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable {
    
    @CreatedBy
    @Column(name = "CreatedBy")
    private String createdBy;
    @Column(name = "CreatedDate")
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "LastUpdatedBy")
    @LastModifiedBy
    private String modifiedBy;
    @Column(name = "LastUpdatedDate")
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
