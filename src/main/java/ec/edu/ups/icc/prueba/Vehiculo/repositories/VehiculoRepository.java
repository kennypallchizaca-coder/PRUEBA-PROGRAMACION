package ec.edu.ups.icc.prueba.Vehiculo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoRepository, Long> {
    Optional<VehiculoRepository> findByIdAndDeletedFalse(String nombre);
    
}
