package com.backend.tes.api;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.service.ClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/classifiers")
public class ClassifierController {

    @Autowired
    private ClassifierService classifierService;

    @GetMapping
    public @ResponseBody ClassifierDto getAllClassifiers(){
        return classifierService.findAllClassifiers();
    }


}
