package com.backend.grupo1.rentacar.entity;

import javax.persistence.*;

@Entity
@Table (name = "VEHICULOS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"marcaYClase"})
})
public class Vehiculo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String marcaYClase;
    private String tipo;

    private String descripcion;
    private int modelo;

    private int numeroPasajeros;

    private int cantidadPuertas;
    private boolean aireAcondicionado;
    private String tipoCajaCambios;


    private double precioAlquiler;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String marcaYClase, String tipo, String descripcion, int modelo, int numeroPasajeros, int cantidadPuertas, boolean aireAcondicionado, String tipoCajaCambios, double precioAlquiler, Imagen imagen) {
        this.id = id;
        this.marcaYClase = marcaYClase;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.numeroPasajeros = numeroPasajeros;
        this.cantidadPuertas = cantidadPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.tipoCajaCambios = tipoCajaCambios;
        this.precioAlquiler = precioAlquiler;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarcaYClase() {
        return marcaYClase;
    }

    public void setMarcaYClase(String marcaYClase) {
        this.marcaYClase = marcaYClase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public String getTipoCajaCambios() {
        return tipoCajaCambios;
    }

    public void setTipoCajaCambios(String tipoCajaCambios) {
        this.tipoCajaCambios = tipoCajaCambios;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
