package ec.edu.ups.icc.prueba.Vehiculo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.icc.prueba.Vehiculo.entities.VehicleEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehicleEntity, Long> {

    // Vehículos activos (deleted = "N")
    List<VehicleEntity> findByDeleted(String deleted);

    // Vehículos con poco stock y precio alto
    List<VehicleEntity> findByStockLessThanAndPriceGreaterThanAndDeleted(Integer stock, Double price, String deleted);

    // Buscar por modelo
    Optional<VehicleEntity> findByModelAndDeleted(String model, String deleted);

    // Buscar por modelo (sin importar estado)
    Optional<VehicleEntity> findByModel(String model);
}
