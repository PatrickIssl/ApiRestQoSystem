package com.issler.patrick.QoSystem.global;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class ImageSave {

    @Value("${contato.disco.diretorio-fotos}")
    private String diretorioFotos;

    public void salvarFoto(MultipartFile foto) {
        this.salvar(this.diretorioFotos, foto);
    }

    public void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }
    }
}
