package com.backend.grupo1.rentacar.repository;

import com.backend.grupo1.rentacar.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository <Vehiculo, Long> {
}
