package com.numble.banking.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Friend {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private Long friendId;

    private LocalDateTime createdDate;      // 친구한 날짜

    @ManyToOne
    @JoinColumn(name = "user_id")     // 어떤 컬럼으로 조인할지 지정
    private User user;

}
