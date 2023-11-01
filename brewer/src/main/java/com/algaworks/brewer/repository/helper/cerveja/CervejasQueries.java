package com.algaworks.brewer.repository.helper.cerveja;

import com.algaworks.brewer.dto.CervejaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.filter.CervejaFilter;

import java.util.List;

public interface CervejasQueries {

    public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);

    public List<CervejaDTO> porSkuOuNome(String skuOuNome);

}
