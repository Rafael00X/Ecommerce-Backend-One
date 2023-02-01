package com.website.backendone.service;

import com.website.backendone.entity.Section;
import com.website.backendone.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    private SectionRepository repository;

    @Autowired
    public SectionServiceImpl(SectionRepository repository) {
        this.repository = repository;
    }

    public List<Section> getAllSections() {
        return repository.findAll();
    }

    public Section getSectionById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
