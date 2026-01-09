package ec.edu.ups.icc.prueba.Vehiculo.services;

import java.util.List;

import ec.edu.ups.icc.prueba.Vehiculo.dtos.OperationResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleStockRequestDto;

public interface VehicleService {

    // ENDPOINT 1: Listar vehículos activos
    List<VehicleResponseDto> findAllActive();

    // ENDPOINT 2: Vehículos con poco stock y precio alto
    List<VehicleResponseDto> findLowStockExpensive();

    // ENDPOINT 3: Eliminación lógica por modelo
    OperationResponseDto deleteByModel(String model);

    // ENDPOINT 4: Actualizar stock de un vehículo
    Object updateStock(VehicleStockRequestDto dto);
}
