package com.luan.luanfood.core.jackson;

import org.springframework.stereotype.Component;

import com.luan.luanfood.api.model.mixin.CidadeMixin;
import com.luan.luanfood.api.model.mixin.CozinhaMixin;
import com.luan.luanfood.domain.model.Cidade;
import com.luan.luanfood.domain.model.Cozinha;

import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}