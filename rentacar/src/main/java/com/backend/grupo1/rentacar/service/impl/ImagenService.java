package com.backend.grupo1.rentacar.service.impl;

import com.backend.grupo1.rentacar.dto.entrada.vehiculo.ImagenEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.ImagenSalidaDto;
import com.backend.grupo1.rentacar.entity.Imagen;
import com.backend.grupo1.rentacar.repository.ImagenRepository;
import com.backend.grupo1.rentacar.service.ImpImagenService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagenService  implements ImpImagenService {
    private final Logger LOGGER= LoggerFactory.getLogger(ImagenService.class);
    private final ImagenRepository imagenRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public ImagenService(ImagenRepository imagenRepository, ModelMapper modelMapper) {
        this.imagenRepository = imagenRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public ImagenSalidaDto agregarImagen(ImagenEntradaDto imagen) {
        Imagen imagenAgregada = imagenRepository.save(dtoEntradaAEntidad(imagen));
        ImagenSalidaDto imagenSalidaDto = entidadADtoSalida(imagenAgregada);
        LOGGER.info ("Imagen agregada: {}", imagenSalidaDto);

        return  imagenSalidaDto;
    }

    @Override
    public List<ImagenSalidaDto> listarGaleriaImagenes() {
        List<Imagen> imagenes = imagenRepository.findAll();

        // Mezcla las imágenes aleatoriamente
        Collections.shuffle(imagenes);

        // Obtiene un número aleatorio de imágenes entre 0 y el tamaño de la lista
        int numImagenes = Math.min(imagenes.size(), 10); // Cambia 10 al número máximo deseado
        List<Imagen> imagenesAleatorias = imagenes.stream()
                .limit(numImagenes)
                .collect(Collectors.toList());

        // Convierte las imágenes en objetos ImagenSalidaDto
        return imagenesAleatorias.stream()
                .map(this::entidadADtoSalida)
                .collect(Collectors.toList());
    }
    private void configureMapping() {
        modelMapper.typeMap(ImagenEntradaDto.class, Imagen.class);
        modelMapper.typeMap(Imagen.class, ImagenSalidaDto.class)
                .addMappings(mapper -> mapper.map(Imagen::getVehiculo, ImagenSalidaDto::setVehiculo));

    }

    private Imagen dtoEntradaAEntidad(ImagenEntradaDto imagenEntradaDto) {
        return  modelMapper.map(imagenEntradaDto, Imagen.class);
    }

    private ImagenSalidaDto   entidadADtoSalida (Imagen imagen) {
        return  modelMapper.map(imagen, ImagenSalidaDto.class);
    }
}
