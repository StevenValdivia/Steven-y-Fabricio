package com.restaurante.cliente.infrastructure;


import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "correo")
public class CorreoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "clienteid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    @Column(name = "correo")
    private String correo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ClienteEntity getCliente()
    {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente)
    {
        this.cliente = cliente;
    }
}