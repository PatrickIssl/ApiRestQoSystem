package com.issler.patrick.QoSystem.controller;

import com.issler.patrick.QoSystem.global.ImageSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequestMapping("/foto")
@Controller
public class FotoController {

    @Autowired
    ImageSave imageSave;

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestParam MultipartFile foto) throws IOException {
        imageSave.salvarFoto(foto);
        return new ResponseEntity("certo" + " path da pasta dos arquivos " + new File("/").getCanonicalPath(), HttpStatus.OK);
    }


}
