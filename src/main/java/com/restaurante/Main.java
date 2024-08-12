package com.restaurante;

import com.restaurante.cliente.adapter.controller.ClienteCreateController;
import com.restaurante.cliente.adapter.presenter.ClienteCreatePresenter;
import com.restaurante.cliente.adapter.presenter.ClienteCreateViewModel;
import com.restaurante.cliente.application.usecase.create.ClienteCreateRequest;
import com.restaurante.cliente.infrastructure.ClienteEntity;
import com.restaurante.cliente.infrastructure.ClienteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner
{
    @Autowired
    private ClienteCreateController controller;

    @Autowired
    private ClienteCreatePresenter present;

    @Autowired
    private ClienteEntityRepository clienteEntityRepository;

    @Override
    public void run(String... args) throws Exception
    {
        List<ClienteEntity> clienteEntityList = clienteEntityRepository.getAll();
        int opcion;
        while(true)
        {
            mostrarOpciones();
            opcion = new Scanner(System.in).nextInt();
            switch(opcion)
            {
                case 1:
                    insert();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Ingreso un indice no registrado");
            }
        }
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);

    }

    public static void mostrarOpciones()
    {
        System.out.println("\n---Seleccione una opcion---");
        System.out.println("1) Insertar");
        System.out.println("2) Mostrar");
        System.out.println("3) Actualizar");
        System.out.println("4) Eliminar");
        System.out.println("5) Saliendo");
    }

    public void insert()
    {
        ClienteCreateRequest request = new ClienteCreateRequest();
        System.out.print("Ingrese el dni del Cliente-> ");
        String dni = new Scanner(System.in).nextLine();
        request.setDni(dni);
        System.out.print("Ingrese el Apellido Paterno del Cliente-> ");
        String paterno = new Scanner(System.in).nextLine();
        request.setPaterno(paterno);
        System.out.print("Ingrese el Apellido Materno del Cliente-> ");
        String materno = new Scanner(System.in).nextLine();
        request.setMaterno(materno);
        System.out.print("Ingrese el Nombre del Cliente-> ");
        String nombre = new Scanner(System.in).nextLine();
        request.setNombre(nombre);
        controller.crear(request);
        ClienteCreateViewModel viewModel = present.getViewModel();
        System.out.println("\n----Datos ingresado----");
        System.out.println("DNI: " + viewModel.getDni());
        System.out.println("Apellido Paterno " + viewModel.getPaterno());
        System.out.println("Apellido Materno: " + viewModel.getMaterno());
        System.out.println("Nombre: " + viewModel.getNombre());
        System.out.println("Fecha de Registro: " + viewModel.getRegistro());
    }

    public static void read()
    {

    }

    public static void update()
    {

    }

    public static void delete()
    {

    }
}