package com.sqc.academy.library.entities;

import com.sqc.academy.library.entities.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends EntityBase {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('admin', 'user') DEFAULT 'user'")
    Role role = Role.USER;
}