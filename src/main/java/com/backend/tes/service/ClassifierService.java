package com.backend.tes.service;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.api.mapper.ClassifierMapper;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.repository.BrandRepository;
import com.backend.tes.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifierService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private BrandRepository brandRepository;

    public ClassifierDto findAllClassifiers() {
        List<Color> colors = colorRepository.findAll();
        List<Brand> brands = brandRepository.findAll();

        return ClassifierMapper.INSTANCE.classifiersToClassifierDto(brands, colors);
    }

}
