package com.restaurante.cliente.adapter.presenter;

import com.restaurante.cliente.application.usecase.create.ClienteCreateResponse;
import com.restaurante.cliente.application.usecase.create.ClienteCreateUseCaseOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ClienteCreatePresenter implements ClienteCreateUseCaseOutput
{

    private ClienteCreateViewModel viewModel;
    public void present(ClienteCreateResponse response)
    {
        viewModel = new ClienteCreateViewModel();
        BeanUtils.copyProperties(response, viewModel);

        String registroToString = dateToString(response.getRegistro());
        viewModel.setRegistro(registroToString);
    }

    public ClienteCreateViewModel getViewModel() {
        return viewModel;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
