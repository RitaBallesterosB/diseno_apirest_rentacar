package com.backend.grupo1.rentacar.controller;

import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoDetalleEntradaDto;
import com.backend.grupo1.rentacar.dto.entrada.vehiculo.VehiculoEntradaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoDetalleSalidaDto;
import com.backend.grupo1.rentacar.dto.salida.vehiculo.VehiculoSalidaDto;
import com.backend.grupo1.rentacar.exceptions.BadRequestException;
import com.backend.grupo1.rentacar.exceptions.ResourceNotFoundException;
import com.backend.grupo1.rentacar.service.IVehiculoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    @Autowired
    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // Método para agregar un vehículo
    @PostMapping("/agregar")
    public ResponseEntity<VehiculoSalidaDto> agregarVehiculo(@Valid @RequestBody VehiculoEntradaDto vehiculo)
            throws BadRequestException {
        return new ResponseEntity<>(vehiculoService.agregarVehiculo(vehiculo), HttpStatus.CREATED);
    }


    // Método para obtener vehículos aleatorios
    @GetMapping("/aleatorios")
    public ResponseEntity<List<VehiculoSalidaDto>> obtenerVehiculosAleatorios() throws ResourceNotFoundException {
        return new ResponseEntity<>(vehiculoService.obtenerVehiculosAleatorios(), HttpStatus.OK);
    }

    // Método para obtener detalles de un vehículo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDetalleSalidaDto> obtenerDetalleVehiculo(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(vehiculoService.obtenerDetalleVehiculo(id), HttpStatus.OK);
    }

    // Método para agregar detalles a un vehículo existente
    @PostMapping("/{id}/detalles")
    public ResponseEntity<VehiculoDetalleSalidaDto> agregarDetalleVehiculo(@PathVariable Long id, @Valid @RequestBody VehiculoDetalleEntradaDto detalleVehiculoDto) throws ResourceNotFoundException {
        detalleVehiculoDto.setId(id); // Establecer el ID del vehículo en los detalles
        return new ResponseEntity<>(vehiculoService.agregarDetalleVehiculo(detalleVehiculoDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarVehiculos() {
        try{
            List<VehiculoSalidaDto> vehiculos = vehiculoService.listarVehiculos();
            return new ResponseEntity<>(vehiculos, HttpStatus.OK);
        }catch (Exception e){
            // Manejo de excepciones aquí, puedes imprimir el error en la consola o manejarlo según tus necesidades
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener la lista de vehículos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método DELETE para eliminar un vehículo por su ID
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable Long id) {
        try {
            vehiculoService.eliminarVehiculo(id);
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonResponse = mapper.createObjectNode();
            jsonResponse.put("mensaje", "Vehículo eliminado exitosamente");
            return ResponseEntity.ok(jsonResponse);
        } catch (NoSuchElementException e) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonResponse = mapper.createObjectNode();
            jsonResponse.put("mensaje", "Vehículo no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonResponse);
        }
    }
}
