package com.backend.grupo1.rentacar.service;

import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoDetalleEntradaDto;
import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoDetalleSalidaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoSalidaDto;
import com.backend.grupo1.rentacar.entity.Vehiculo;
import com.backend.grupo1.rentacar.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IVehiculoService {

    VehiculoSalidaDto agregarVehiculo(VehiculoEntradaDto vehiculo);

    //___________________________________________________________________________________________

    VehiculoDetalleSalidaDto agregarDetalleVehiculo(VehiculoDetalleEntradaDto detalleVehiculo) throws ResourceNotFoundException;


    //___________________________________________________________________________________________

    List<VehiculoSalidaDto>obtenerVehiculosAleatorios();

    //___________________________________________________________________________________________
    VehiculoDetalleSalidaDto obtenerDetalleVehiculo(Long id) throws ResourceNotFoundException;

    List<VehiculoSalidaDto> listarVehiculos();
    void eliminarVehiculo(Long id);
}


