package com.luan.luanfood.core.jackson;

import org.springframework.stereotype.Component;

import com.luan.luanfood.api.model.mixin.CidadeMixin;
import com.luan.luanfood.api.model.mixin.CozinhaMixin;
import com.luan.luanfood.api.model.mixin.RestauranteMixin;
import com.luan.luanfood.domain.model.Cidade;
import com.luan.luanfood.domain.model.Cozinha;
import com.luan.luanfood.domain.model.Restaurante;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}