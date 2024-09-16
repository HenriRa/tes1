package com.backend.tes.api;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classifiers")
public class ClassifierController {

    private final ClassifierService classifierService;

    @GetMapping
    public @ResponseBody ClassifierDto getAllClassifiers(){
        return classifierService.findAllClassifiers();
    }


}
