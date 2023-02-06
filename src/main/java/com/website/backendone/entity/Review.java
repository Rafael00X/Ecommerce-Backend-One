package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {
    @Id
    @GeneratedValue
    private Integer reviewId;
    private Integer userId;
    private String userName;
    private Integer rating;
    private String text;
    @CreationTimestamp
    private Date createdAt;
    @ManyToOne
    @JsonBackReference
    private Product product;
}
