package com.algaworks.brewer.controller;

import com.algaworks.brewer.storage.FotoStorageRunnable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

    @PostMapping
    public DeferredResult<String> upload(@RequestParam("files[]")  MultipartFile[] files){
        DeferredResult<String> resultado = new DeferredResult<>();

        Thread thread = new Thread(new FotoStorageRunnable(files,resultado));
        thread.start();

        return resultado;
    }

}
