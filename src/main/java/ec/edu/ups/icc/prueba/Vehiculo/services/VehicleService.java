package ec.edu.ups.icc.prueba.Vehiculo.services;

import java.util.List;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.CreateVehicleDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.PartialVehicleDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;

public interface VehicleService {
	List<VehicleResponseDto> findAll();
	Object findById(int id);
	VehicleResponseDto create(CreateVehicleDto dto);
	Object update(int id, CreateVehicleDto dto);
	Object updatePartial(int id, PartialVehicleDto dto);
	Object delete(int id);
}
