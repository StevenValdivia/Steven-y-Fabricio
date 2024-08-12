package com.restaurante.cliente.application.repository;

import com.restaurante.cliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository
{
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    Cliente delete(Cliente cliente);
    List<Cliente> retrieveList();
}