package com.curso.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Veterinaria;
@ConditionalOnMissingBean(name="defaultKeyStoreService")
public interface VeterinariaDao extends JpaRepository<Veterinaria, String> {

}
