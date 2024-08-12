package com.restaurante.cliente.infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

@Entity
@Table(schema = "public", name = "cliente")
public class ClienteEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "materno")
    private String materno;

    @Column(name = "nombre")
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "registro")
    private Date registro;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<CorreoEntity> correoEntitySet;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public String getPaterno()
    {
        return paterno;
    }

    public void setPaterno(String paterno)
    {
        this.paterno = paterno;
    }

    public String getMaterno()
    {
        return materno;
    }

    public void setMaterno(String materno)
    {
        this.materno = materno;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Date getRegistro()
    {
        return registro;
    }

    public void setRegistro(Date registro)
    {
        this.registro = registro;
    }

    public Set<CorreoEntity> getCorreoEntitySet()
    {
        return correoEntitySet;
    }

    public void setCorreoEntitySet(Set<CorreoEntity> correoEntitySet)
    {
        this.correoEntitySet = correoEntitySet;
    }
}