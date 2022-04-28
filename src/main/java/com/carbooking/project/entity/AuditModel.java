package com.carbooking.project.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;


    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public abstract class AuditModel implements Serializable {

        private static final long serialVersionUID = 1L;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_at", nullable = true, updatable = false)
        @CreatedDate
        @JsonIgnore
        public Date createdAt;



        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "updated_at", nullable = true, updatable = true)
        @JsonIgnore
        @LastModifiedDate
        public Date updatedAt;



        protected AuditModel() {
            // Default constructor
        }

    }

