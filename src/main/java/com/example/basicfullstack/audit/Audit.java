package com.example.basicfullstack.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class Audit {

    @Column( name = "created_at", nullable = false, updatable = false )
    @CreationTimestamp
    private Date createdAt;

    @Column( name = "updated_at", nullable = false )
    @UpdateTimestamp
    private Date updatedAt;
}