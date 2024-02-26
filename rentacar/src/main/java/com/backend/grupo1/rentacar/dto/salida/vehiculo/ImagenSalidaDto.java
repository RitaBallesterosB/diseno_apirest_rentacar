package com.backend.grupo1.rentacar.dto.salida.vehiculo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ImagenSalidaDto {



    private String nombre;

    private String url;

    private VehiculoSalidaDto vehiculo;

    public ImagenSalidaDto() {
    }

    public ImagenSalidaDto(String nombre, String url, VehiculoSalidaDto vehiculo) {
        this.nombre = nombre;
        this.url = url;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VehiculoSalidaDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoSalidaDto vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() { return "nombre:" + nombre  + '\'' + ", url=" + url; }
}
