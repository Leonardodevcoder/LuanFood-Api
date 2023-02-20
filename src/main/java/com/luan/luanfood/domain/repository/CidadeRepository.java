package com.luan.luanfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luan.luanfood.domain.model.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}