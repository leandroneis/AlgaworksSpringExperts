package com.algaworks.brewer.storage.local;
import static java.nio.file.FileSystems.getDefault;

import com.algaworks.brewer.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

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

    @Override
    public void salvarTemporariamente(MultipartFile[] files) {
        System.out.println(">> Salvando a foto temporariamente....");
    }
}
