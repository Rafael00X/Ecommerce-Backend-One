package com.website.backendone.service;

import com.website.backendone.entity.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSections();
    Section getSectionById(Integer id);
}
