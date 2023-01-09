package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String imageUrl;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
    @ManyToOne
    @JsonBackReference
    private Section section;
}
