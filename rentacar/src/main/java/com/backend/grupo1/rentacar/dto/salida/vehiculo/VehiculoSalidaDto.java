package com.backend.grupo1.rentacar.dto.salida.vehiculo;

public class VehiculoSalidaDto {

    private Long id;
    private String marcaYClase;
    private String descripcion;
    private ImagenSalidaDto imagen;

    public VehiculoSalidaDto() {
    }

    public VehiculoSalidaDto(Long id, String marcaYClase, String descripcion, ImagenSalidaDto imagen) {
        this.id = id;
        this.marcaYClase = marcaYClase;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImagenSalidaDto getImagen() {
        return imagen;
    }

    public void setImagen(ImagenSalidaDto imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() { return "id:" + id + ", marcaYClase: " + marcaYClase + '\'' + ", descripcion: " + descripcion + '\'' + ", imagen=" + imagen; }
}
