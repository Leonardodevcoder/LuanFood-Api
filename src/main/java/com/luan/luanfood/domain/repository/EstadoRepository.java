package com.luan.luanfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luan.luanfood.domain.model.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}