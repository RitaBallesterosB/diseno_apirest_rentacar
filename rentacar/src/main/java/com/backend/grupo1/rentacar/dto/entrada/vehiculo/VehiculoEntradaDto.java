package com.backend.grupo1.rentacar.dto.entrada.vehiculo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties (ignoreUnknown = true)

public class VehiculoEntradaDto {

    @Size (min = 2, max = 100, message = "La marca y clase debe tener hasta 100 caracteres")

    @NotNull(message ="La marca y modelo no deben estar nulos")

    private String marcaYClase;

    @Size (min = 2, max = 100, message = "La descripción debe tener hasta 150 caracteres")

    @NotNull(message ="La descripción no deben estar nula")
    private String descripcion;

    @NotNull(message = "La imagen del vehiculo no puede ser nula")

    @Valid

    private ImagenEntradaDto imagen;

    public VehiculoEntradaDto() {
    }

    public VehiculoEntradaDto(String marcaYClase, String descripcion, ImagenEntradaDto imagen) {
        this.marcaYClase = marcaYClase;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getMarcaYClase() {
        return marcaYClase;
    }

    public void setMarcaYClase(String marcaYClase) {
        this.marcaYClase = marcaYClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImagenEntradaDto getImagen() {
        return imagen;
    }

    public void setImagen(ImagenEntradaDto imagen) {
        this.imagen = imagen;
    }
}
