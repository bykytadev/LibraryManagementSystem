package com.sqc.academy.library.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public abstract class EntityBase implements Serializable {

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime modifiedDate;

    @Column(name = "in_active")
    boolean inActive;

    @Column(name = "is_delete")
    boolean isDelete;
}