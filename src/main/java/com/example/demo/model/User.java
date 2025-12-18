// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.util.Set;

// @Entity
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @Table(name = "users") // avoids conflict with SQL reserved word
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     /**
//      * Roles like: ROLE_ADMIN, ROLE_USER
//      * Tests expect roles to exist and be readable
//      */
//     @ElementCollection(fetch = FetchType.EAGER)
//     @CollectionTable(
//         name = "user_roles",
//         joinColumns = @JoinColumn(name = "user_id")
//     )
//     @Column(name = "role")
//     private Set<String> roles;
// }
