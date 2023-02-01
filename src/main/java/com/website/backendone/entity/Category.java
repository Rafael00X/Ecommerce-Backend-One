package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonFilter(Category.FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    public static final String FILTER = "category-filter";
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private String imageUrl;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Section section;
}
