package com.backend.grupo1.rentacar.dto.entrada.vehiculo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



    @JsonIgnoreProperties(ignoreUnknown = true)

    public class ImagenEntradaDto {



        @NotNull(message ="El nombre  no debe estar nulo")
        @NotBlank (message = "debe especificrse el nombre de la imagen")

        private String nombre;

        @Size (min = 2, max = 400, message = "La descripción debe tener hasta 400 caracteres")

        @NotNull(message ="La descripción no deben estar nula")
        private String url;

        public ImagenEntradaDto() {
        }

        public ImagenEntradaDto(String nombre, String url) {
            this.nombre = nombre;
            this.url = url;
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
    }
