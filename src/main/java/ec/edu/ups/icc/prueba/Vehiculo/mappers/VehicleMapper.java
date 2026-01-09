

package ec.edu.ups.icc.prueba.Vehiculo.mappers;

import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.entities.VehicleEntity;

public class VehicleMapper {

    public static VehicleResponseDto toResponseDto(VehicleEntity entity) {
        VehicleResponseDto dto = new VehicleResponseDto();
        dto.id = entity.getId();
        dto.brand = entity.getBrand();
        dto.model = entity.getModel();
        dto.price = entity.getPrice();
        dto.stock = entity.getStock();
        return dto;
    }
}