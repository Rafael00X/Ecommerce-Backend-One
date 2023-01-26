package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.website.backendone.constants.JacksonFilterConstants;
import jakarta.persistence.*;
import lombok.*;

@JsonFilter(JacksonFilterConstants.PRODUCT_FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String imageUrl;
    @Column(length = 1000)
    private String description;
    private Integer markedPrice;
    private Integer sellingPrice;
    private Integer reviewCount;
    private Integer totalRating;
    @ManyToOne
    @JsonBackReference
    private Category category;
}
