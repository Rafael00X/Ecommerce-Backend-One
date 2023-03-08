package com.website.backendone.controller;

import com.website.backendone.entity.Category;
import com.website.backendone.entity.Product;
import com.website.backendone.entity.Section;
import com.website.backendone.service.*;
import com.website.backendone.utility.MappingJacksonValueBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections")
    public MappingJacksonValue getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return MappingJacksonValueBuilder.init(sections)
                .addFilter(Section.FILTER)
                .addFilter(Category.FILTER, "products")
                .build();
    }

    @GetMapping("/sections/{id}")
    public MappingJacksonValue getSection(@PathVariable Integer id) {
        Section section = sectionService.getSectionById(id);
        return MappingJacksonValueBuilder.init(section)
                .addFilter(Section.FILTER)
                .addFilter(Category.FILTER, "products")
                .build();
    }
}