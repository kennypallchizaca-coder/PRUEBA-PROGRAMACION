

package ec.edu.ups.icc.prueba.Vehiculo.mappers;

import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.models.Vehicle;

public class VehicleMapper {
    public static Vehicle toEntity(String brand, String model, Double price, Integer stock, int id) {
        return new Vehicle(id, brand, model, price, stock);
    }

    public static VehicleResponseDto toResponseDto(Vehicle vehicle) {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.id = (long) vehicle.getId();
        dto.brand = vehicle.getBrand();
        dto.model = vehicle.getModel();
        dto.price = vehicle.getPrice();
        dto.stock = vehicle.getStock();
        return dto;
    }
}