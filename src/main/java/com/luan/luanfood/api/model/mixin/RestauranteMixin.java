package com.luan.luanfood.api.model.mixin;

import java.time.OffsetDateTime;
import java.util.List;

import com.luan.luanfood.domain.model.Cozinha;
import com.luan.luanfood.domain.model.Endereco;
import com.luan.luanfood.domain.model.FormaPagamento;
import com.luan.luanfood.domain.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public abstract class RestauranteMixin {

    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

    @JsonIgnore
    private OffsetDateTime dataCadastro;

    @JsonIgnore
    private OffsetDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento;

    @JsonIgnore
    private List<Produto> produtos;

}