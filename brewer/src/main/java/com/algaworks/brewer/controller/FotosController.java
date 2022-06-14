package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

    @PostMapping
    public String upload(@RequestParam("files[]")  MultipartFile[] files){
        return "Ok!";
    }

}
