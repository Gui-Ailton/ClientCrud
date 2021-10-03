package com.devsuperior.crudCliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.crudCliente.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
