package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    @Column(updatable = false, nullable = false)
    private String accountNum;

    @Column(updatable = false, name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    private int balance;
}
