//package com.numble.banking.domain;
//
//import jakarta.persistence.*;
//import lombok.NonNull;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table
//public class User {
//    @Id
//    private String id;
//
//    @NonNull
//    private String pw;
//
//    @NonNull
//    private String name;
//
//    private int age;
//
//    @Column(updatable = false, name = "created_date", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Enumerated(value = EnumType.STRING)
//    private Gender gender;
//
//    private int phoneNum;
//}
