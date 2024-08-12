package com.restaurante.cliente.application.usecase.create;

import com.restaurante.cliente.application.repository.ClienteRepository;
import com.restaurante.cliente.domain.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class ClienteCreateUseCase implements ClienteCreateUseCaseInput
{
    @Autowired
    private ClienteCreateUseCaseOutput clienteCreateUseCaseOutput;

    @Autowired
    private ClienteRepository clienteRepository;

    public void create(ClienteCreateRequest request)
    {
        Date fechaActual = new Date();
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(request, cliente);
        cliente.setRegistro(fechaActual);
        clienteRepository.create(cliente);

        ClienteCreateResponse response = new ClienteCreateResponse();
        BeanUtils.copyProperties(request, response);
        response.setRegistro(fechaActual);
        clienteCreateUseCaseOutput.present(response);
    }
}