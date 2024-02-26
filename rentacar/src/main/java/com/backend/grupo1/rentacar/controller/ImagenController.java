package com.backend.grupo1.rentacar.controller;


import com.backend.grupo1.rentacar.dto.entrada.vehiculo.ImagenEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.ImagenSalidaDto;
import com.backend.grupo1.rentacar.service.ImpImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vehiculos/{idVehiculo}/imagenes")
    public class ImagenController {

        private final ImpImagenService imagenService;


        @Autowired
        public ImagenController(ImpImagenService imagenService) {
            this.imagenService = imagenService;
        }

        @PostMapping("/agregar")
        public ResponseEntity<ImagenSalidaDto> agregarImagen(@Valid @RequestBody ImagenEntradaDto imagen) {
            return new ResponseEntity<>(imagenService.agregarImagen(imagen), HttpStatus.CREATED);
        }
    }


