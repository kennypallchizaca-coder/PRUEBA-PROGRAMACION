package ec.edu.ups.icc.prueba.Vehiculo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.icc.prueba.Vehiculo.dtos.OperationResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleStockRequestDto;
import ec.edu.ups.icc.prueba.Vehiculo.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // ENDPOINT 1: GET /api/vehicles - Listar vehículos activos
    @GetMapping
    public List<VehicleResponseDto> findAllActive() {
        return service.findAllActive();
    }

    // ENDPOINT 2: GET /api/vehicles/low-stock-expensive - Vehículos con poco stock y precio alto
    @GetMapping("/low-stock-expensive")
    public List<VehicleResponseDto> findLowStockExpensive() {
        return service.findLowStockExpensive();
    }

    // ENDPOINT 3: PATCH /api/vehicles/delete/{model} - Eliminación lógica por modelo
    @PatchMapping("/delete/{model}")
    public OperationResponseDto deleteByModel(@PathVariable String model) {
        return service.deleteByModel(model);
    }

    // ENDPOINT 4: PATCH /api/vehicles/stock - Actualizar stock de un vehículo
    @PatchMapping("/stock")
    public Object updateStock(@RequestBody VehicleStockRequestDto dto) {
        return service.updateStock(dto);
    }
}
