package com.restaurante.cliente.infrastructure;

import com.restaurante.cliente.application.repository.ClienteRepository;
import com.restaurante.cliente.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClienteRepositoryImpl implements ClienteRepository
{
    @Autowired
    private ClienteEntityRepository clienteEntityRepository;

    @Override
    public Cliente create(Cliente cliente)
    {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setDni(cliente.getDni());
        clienteEntity.setPaterno(cliente.getPaterno());
        clienteEntity.setMaterno(cliente.getMaterno());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setRegistro(cliente.getRegistro());
        clienteEntityRepository.save(clienteEntity);

        cliente.setId(clienteEntity.getId());
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente)
    {
        return null;
    }

    @Override
    public Cliente delete(Cliente cliente)
    {
        return null;
    }

    @Override
    public List<Cliente> retrieveList()
    {
        List<ClienteEntity> clienteEntityList = clienteEntityRepository.getAll();
        return null;
    }
}