package com.softwaresprint.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "property")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @Column(name = "property_title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)

    private String description;
    @Column(name = "owner", nullable = false)

    private String owner;
    @Column(name = "email", nullable = false, unique = true)

    private String email;
    @Column(name = "price", nullable = false)

    private Double price;
    @Column(name = "address", nullable = false)

    private String address;
}
