package com.backend.grupo1.rentacar.service.impl;

import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoDetalleEntradaDto;
import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoDetalleSalidaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoSalidaDto;
import com.backend.grupo1.rentacar.entity.Vehiculo;
import com.backend.grupo1.rentacar.exceptions.ResourceNotFoundException;
import com.backend.grupo1.rentacar.repository.VehiculoRepository;
import com.backend.grupo1.rentacar.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VehiculoService implements IVehiculoService {

    private final Logger LOGGER= LoggerFactory.getLogger(VehiculoService.class);
    private final VehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository, ModelMapper modelMapper) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public VehiculoSalidaDto agregarVehiculo(VehiculoEntradaDto vehiculo) {
        Vehiculo vehiculoAgregado = vehiculoRepository.save(dtoEntradaAEntidad(vehiculo));
        VehiculoSalidaDto vehiculoSalidaDto = entidadAdtoSalida(vehiculoAgregado);
        LOGGER.info("Vehiculo agreagado: {}", vehiculoSalidaDto);


        return vehiculoSalidaDto;
    }

    @Override
    public VehiculoDetalleSalidaDto agregarDetalleVehiculo(VehiculoDetalleEntradaDto detalleVehiculo) throws ResourceNotFoundException {
        Vehiculo vehiculo = vehiculoRepository.findById(detalleVehiculo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con ID: " + detalleVehiculo.getId()));

        vehiculo.setTipo(detalleVehiculo.getTipo());
        vehiculo.setModelo(detalleVehiculo.getModelo());
        vehiculo.setNumeroPasajeros(detalleVehiculo.getNumeroPasajeros());
        vehiculo.setCantidadPuertas(detalleVehiculo.getCantidadPuertas());
        vehiculo.setAireAcondicionado(detalleVehiculo.isAireAcondicionado());
        vehiculo.setTipoCajaCambios(detalleVehiculo.getTipoCajaCambios());
        vehiculo.setPrecioAlquiler(detalleVehiculo.getPrecioAlquiler());

        Vehiculo vehiculoGuardado = vehiculoRepository.save(vehiculo);
        return modelMapper.map(vehiculoGuardado, VehiculoDetalleSalidaDto.class);
    }


    private void configureMapping() {
        modelMapper.typeMap(VehiculoEntradaDto.class, Vehiculo.class)
                .addMappings(mapper -> mapper.map(VehiculoEntradaDto::getImagen, Vehiculo::setId));
        modelMapper.typeMap(Vehiculo.class, VehiculoSalidaDto.class)
                .addMappings(mapper -> mapper.map(Vehiculo::getId, VehiculoSalidaDto::setImagen));
    }
    private Vehiculo dtoEntradaAEntidad(VehiculoEntradaDto vehiculoEntradaDto) {
        return  modelMapper.map(vehiculoEntradaDto, Vehiculo.class);
    }

    private VehiculoSalidaDto   entidadAdtoSalida (Vehiculo vehiculo) {
        return  modelMapper.map(vehiculo, VehiculoSalidaDto.class);
    }
//___________________________________________________________________________________________________



    public List<VehiculoSalidaDto> obtenerVehiculosAleatorios() {
        List<Vehiculo> todosLosVehiculos = vehiculoRepository.findAll();


        // Si hay menos de 4 Vehiculos o los que quiera mostrar, en este caso 4, devolver todos los vehiculos
        if (todosLosVehiculos.size() <= 4) {
            return todosLosVehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoSalidaDto.class))
                    .toList();
        }


        // Mezclar todos los productos aleatoriamente
        Collections.shuffle(todosLosVehiculos);

        //   Usamos Set para almacenar los elementos y HashSet que no permite duplicados
        Set<Long> vehiculosSeleccionados = new HashSet<>();
        List<VehiculoSalidaDto> vehiculosAleatorios = todosLosVehiculos.stream()
                .filter(vehiculo -> vehiculosSeleccionados.add(vehiculo.getId()))
                .limit(4)
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoSalidaDto.class))
                .toList();

        return vehiculosAleatorios;
    }




    //___________________________________________________________________________________________________


    //endpoint para obetener detalle de vehiculo


    @Override
    public VehiculoDetalleSalidaDto obtenerDetalleVehiculo(Long id) throws ResourceNotFoundException {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con ID: " + id));

        return mapToVehiculoDetalleSalidaDto(vehiculo);
    }

    private VehiculoDetalleSalidaDto mapToVehiculoDetalleSalidaDto(Vehiculo vehiculo) {
        VehiculoDetalleSalidaDto detalleSalidaDto = new VehiculoDetalleSalidaDto();
        detalleSalidaDto.setId(vehiculo.getId());
        detalleSalidaDto.setTipo(vehiculo.getTipo());
        detalleSalidaDto.setModelo(vehiculo.getModelo());
        detalleSalidaDto.setNumeroPasajeros(vehiculo.getNumeroPasajeros());
        detalleSalidaDto.setCantidadPuertas(vehiculo.getCantidadPuertas());
        detalleSalidaDto.setAireAcondicionado(vehiculo.isAireAcondicionado());
        detalleSalidaDto.setTipoCajaCambios(vehiculo.getTipoCajaCambios());
        detalleSalidaDto.setPrecioAlquiler(vehiculo.getPrecioAlquiler());
        return detalleSalidaDto;
    }



}





