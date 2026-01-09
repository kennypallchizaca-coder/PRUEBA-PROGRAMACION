

package ec.edu.ups.icc.prueba.Vehiculo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.CreateVehicleDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.PartialVehicleDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.mappers.VehicleMapper;
import ec.edu.ups.icc.prueba.Vehiculo.models.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

    private List<Vehicle> vehicles = new ArrayList<>();
    private int currentId = 1;

    @Override
    public List<VehicleResponseDto> findAll() {
        return vehicles.stream().map(VehicleMapper::toResponseDto).toList();
    }

    @Override
    public Object findById(int id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .map(VehicleMapper::toResponseDto)
                .orElseThrow(() -> new java.util.NoSuchElementException("Vehicle not found"));
    }

    @Override
    public VehicleResponseDto create(CreateVehicleDto dto) {
        Vehicle vehicle = VehicleMapper.toEntity(dto.brand, dto.model, dto.price, dto.stock, currentId++);
        vehicles.add(vehicle);
        return VehicleMapper.toResponseDto(vehicle);
    }

    @Override
    public Object update(int id, CreateVehicleDto dto) {
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        if (vehicle == null) return new Object() { public String error = "Vehicle not found"; };

        vehicle.setBrand(dto.brand);
        vehicle.setModel(dto.model);
        vehicle.setPrice(dto.price);
        vehicle.setStock(dto.stock);

        return VehicleMapper.toResponseDto(vehicle);
    }

    @Override
    public Object updatePartial(int id, PartialVehicleDto dto) {
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        if (vehicle == null) return new Object() { public String error = "Vehicle not found"; };

        if (dto.brand != null) vehicle.setBrand(dto.brand);
        if (dto.model != null) vehicle.setModel(dto.model);
        if (dto.price != null) vehicle.setPrice(dto.price);
        if (dto.stock != null) vehicle.setStock(dto.stock);

        return VehicleMapper.toResponseDto(vehicle);
    }

    @Override
    public Object delete(int id) {
        boolean removed = vehicles.removeIf(v -> v.getId() == id);
        if (!removed) return new Object() { public String error = "Vehicle not found"; };
        return new Object() { public String message = "Deleted successfully"; };
    }

}
