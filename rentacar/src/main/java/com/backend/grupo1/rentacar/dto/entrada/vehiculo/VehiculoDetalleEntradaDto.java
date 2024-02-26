package com.backend.grupo1.rentacar.dto.entrada.vehiculo;

public class VehiculoDetalleEntradaDto {

    private Long id;

    private String tipo;

    private int modelo;

    private int numeroPasajeros;

    private int cantidadPuertas;
    private boolean aireAcondicionado;
    private String tipoCajaCambios;


    private double precioAlquiler;

    public VehiculoDetalleEntradaDto() {
    }

    public VehiculoDetalleEntradaDto(Long id, String tipo, int modelo, int numeroPasajeros, int cantidadPuertas, boolean aireAcondicionado, String tipoCajaCambios, double precioAlquiler) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.numeroPasajeros = numeroPasajeros;
        this.cantidadPuertas = cantidadPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.tipoCajaCambios = tipoCajaCambios;
        this.precioAlquiler = precioAlquiler;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
