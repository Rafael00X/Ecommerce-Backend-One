package com.website.backendone.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.website.backendone.constants.JacksonFilterConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@JsonFilter(JacksonFilterConstants.SECTION_FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Section {
    @Id
    @GeneratedValue
    private Integer sectionId;
    private String sectionName;
    @OneToMany(mappedBy = "section")
    @JsonManagedReference
    private List<Category> categories;
}
