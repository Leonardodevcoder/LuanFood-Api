package com.luan.luanfood.domain.service;

import com.luan.luanfood.domain.exception.EntidadeNaoEncontradaException;
import com.luan.luanfood.domain.model.Cozinha;
import com.luan.luanfood.domain.model.Restaurante;
import com.luan.luanfood.domain.repository.CozinhaRepository;
import com.luan.luanfood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

}