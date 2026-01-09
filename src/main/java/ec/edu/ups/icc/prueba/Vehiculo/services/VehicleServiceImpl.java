

package ec.edu.ups.icc.prueba.Vehiculo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.ups.icc.prueba.Vehiculo.dtos.OperationResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleStockRequestDto;
import ec.edu.ups.icc.prueba.Vehiculo.entities.VehicleEntity;
import ec.edu.ups.icc.prueba.Vehiculo.mappers.VehicleMapper;
import ec.edu.ups.icc.prueba.Vehiculo.repositories.VehiculoRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehiculoRepository repository;

    public VehicleServiceImpl(VehiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VehicleResponseDto> findAllActive() {
        List<VehicleEntity> vehicles = repository.findByDeleted("N");
        return vehicles.stream()
                .map(VehicleMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<VehicleResponseDto> findLowStockExpensive() {
        // stock < 5, price > 30000, deleted = "N"
        List<VehicleEntity> vehicles = repository
                .findByStockLessThanAndPriceGreaterThanAndDeleted(5, 30000.0, "N");
        return vehicles.stream()
                .map(VehicleMapper::toResponseDto)
                .toList();
    }

    @Override
    public OperationResponseDto deleteByModel(String model) {
        Optional<VehicleEntity> vehicleOpt = repository.findByModelAndDeleted(model, "N");

        if (vehicleOpt.isEmpty()) {
            return new OperationResponseDto("No se puede eliminar: el vehículo con modelo '" + model + "' no existe o ya está eliminado.");
        }

        VehicleEntity vehicle = vehicleOpt.get();
        vehicle.setDeleted("S");
        repository.save(vehicle);

        return new OperationResponseDto("Vehículo con modelo '" + model + "' eliminado correctamente.");
    }

    @Override
    public Object updateStock(VehicleStockRequestDto dto) {
        if (dto.stock == null || dto.stock < 0) {
            return new OperationResponseDto("El stock no puede ser negativo.");
        }

        Optional<VehicleEntity> vehicleOpt = repository.findByModelAndDeleted(dto.model, "N");

        if (vehicleOpt.isEmpty()) {
            return new OperationResponseDto("No se puede actualizar: el vehículo con modelo '" + dto.model + "' no existe o está eliminado.");
        }

        VehicleEntity vehicle = vehicleOpt.get();
        vehicle.setStock(dto.stock);
        repository.save(vehicle);

        return VehicleMapper.toResponseDto(vehicle);
    }
}
