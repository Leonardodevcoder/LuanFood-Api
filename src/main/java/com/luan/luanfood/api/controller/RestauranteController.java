package com.luan.luanfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.luan.luanfood.api.assembler.RestauranteInputDisassembler;
import com.luan.luanfood.api.assembler.RestauranteModelAssembler;
import com.luan.luanfood.api.model.RestauranteModel;
import com.luan.luanfood.api.model.input.RestauranteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.luan.luanfood.domain.exception.CozinhaNaoEncontradaException;
import com.luan.luanfood.domain.exception.NegocioException;
import com.luan.luanfood.domain.model.Restaurante;
import com.luan.luanfood.domain.repository.RestauranteRepository;
import com.luan.luanfood.domain.service.CadastroRestauranteService;


@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private RestauranteModelAssembler restauranteModelAssembler;

    @Autowired
    private RestauranteInputDisassembler restauranteInputDisassembler;

    @GetMapping
    public List<RestauranteModel> listar() {
        return restauranteModelAssembler.toCollectionModel(restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteModel buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return restauranteModelAssembler.toModel(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
        try {
            Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);

            return restauranteModelAssembler.toModel(cadastroRestaurante.salvar(restaurante));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public RestauranteModel atualizar(@PathVariable Long restauranteId,
                                      @RequestBody @Valid RestauranteInput restauranteInput) {
        try {
            Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

            restauranteInputDisassembler.copyToDomainObject(restauranteInput, restauranteAtual);

            return restauranteModelAssembler.toModel(cadastroRestaurante.salvar(restauranteAtual));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativar(@PathVariable Long restauranteId) {
        cadastroRestaurante.ativar(restauranteId);
    }

    @DeleteMapping("/{restauranteId}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable Long restauranteId) {
        cadastroRestaurante.inativar(restauranteId);
    }

}