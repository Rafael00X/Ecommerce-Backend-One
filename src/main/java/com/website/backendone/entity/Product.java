package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonFilter(Product.FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    public static final String FILTER = "product-filter";
    @Id
    @GeneratedValue
    private Integer productId;
    private String productName;
    private String imageUrl;
    @Column(length = 1000)
    private String description;
    private Integer markedPrice;
    private Integer sellingPrice;
    private Integer reviewCount;
    private Integer totalRating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Review> reviews;
}
