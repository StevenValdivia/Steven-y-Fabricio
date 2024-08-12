package com.restaurante.cliente.adapter.controller;

import com.restaurante.cliente.application.usecase.create.ClienteCreateRequest;
import com.restaurante.cliente.application.usecase.create.ClienteCreateUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateController {

    @Autowired
    private ClienteCreateUseCaseInput clienteCreateUseCaseInput;

    public void crear(ClienteCreateRequest request)
    {
        clienteCreateUseCaseInput.create(request);
    }
}
