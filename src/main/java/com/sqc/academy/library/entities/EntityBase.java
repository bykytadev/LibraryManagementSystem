package com.sqc.academy.library.entities;

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

/**
 * Lớp cơ sở trừu tượng EntityBase
 * - Đây là một lớp cơ sở dùng để theo dõi thông tin audit cho các entity
 *
 * Các trường dữ liệu:
 *
 * @createdDate : Thời điểm tạo bản ghi
 * @modifiedDate : Thời điểm cập nhật bản ghi gần nhất
 *
 *               Các annotation:
 * @MappedSuperclass : Đánh dấu đây là lớp cha cho các entity
 * @EntityListeners : Tự động cập nhật các trường audit
 * @FieldDefaults : Đặt access level mặc định cho các trường
 */

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public abstract class EntityBase {

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime modifiedDate;
}