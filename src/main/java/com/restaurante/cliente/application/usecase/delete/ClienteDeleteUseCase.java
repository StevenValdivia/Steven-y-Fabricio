package com.restaurante.cliente.application.usecase.delete;

import com.restaurante.cliente.domain.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteDeleteUseCase implements ClienteDeleteUseCaseInput
{
    @Autowired
    private ClienteDeleteUseCaseInput clienteDeleteUseCaseInput;

    @Override
    public void borrar(ClienteDeleteRequest request)
    {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(request, cliente);

    }
}
