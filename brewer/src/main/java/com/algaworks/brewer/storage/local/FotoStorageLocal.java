package com.algaworks.brewer.storage.local;
import static java.nio.file.FileSystems.getDefault;

import com.algaworks.brewer.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FotoStorageLocal implements FotoStorage {
    private static final Logger logger = LoggerFactory.getLogger(FotoStorageLocal.class);

    private Path local;
    private Path localtemporario;

    public FotoStorageLocal(){
        this(getDefault().getPath(System.getenv("HOME"),".brewerfotos"));
    }

    public FotoStorageLocal(Path path){
        this.local = path;
        criarPastas();
    }

    @Override
    public String salvarTemporariamente(MultipartFile[] files) {
        String novoNome = null;
        if(files != null && files.length > 0) {
            MultipartFile arquivo = files[0];
            novoNome = renomearArquivo(arquivo.getOriginalFilename());
            try {
                arquivo.transferTo(new File(this.localtemporario.toAbsolutePath().toString()+ getDefault().getSeparator() + novoNome));
            } catch (IOException e) {
                throw new RuntimeException("Erro salvando a foto na pasta temporária",e);
            }
        }
        return novoNome;
    }
    private void criarPastas() {
        try {
            Files.createDirectories(this.local);
            this.localtemporario = getDefault().getPath(this.local.toString(), "temp");
            Files.createDirectories(this.localtemporario);

            if(logger.isDebugEnabled()){
                logger.debug("Pastas criadas para salvar foto.");
                logger.debug("Pastas default: " + this.local.toAbsolutePath());
                logger.debug("Pasta Temporária: " + this.localtemporario.toAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro criando pasta para salvar foto", e);
        }
    }

    private String renomearArquivo(String nomeOrinal){
        String novoNome = UUID.randomUUID().toString() + "_" + nomeOrinal;
        if(logger.isDebugEnabled()){
            logger.debug(String.format("Nome original: %s,novo nome do arquivo: %s",nomeOrinal,novoNome));
        }
        return novoNome;
    }

}
