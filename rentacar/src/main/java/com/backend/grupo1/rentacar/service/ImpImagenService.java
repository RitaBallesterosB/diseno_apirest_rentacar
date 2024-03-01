package com.backend.grupo1.rentacar.service;

import com.backend.grupo1.rentacar.dto.entrada.vehiculo.ImagenEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.ImagenSalidaDto;

import java.util.List;

public interface ImpImagenService {
    ImagenSalidaDto agregarImagen(ImagenEntradaDto imagen);

    List<ImagenSalidaDto> listarGaleriaImagenes();
}
