package com.luan.luanfood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luan.luanfood.domain.model.Restaurante;

import java.util.List;

public abstract class CozinhaMixin {

    @JsonIgnore
    private List<Restaurante> restaurantes;

}
