package ec.edu.ups.icc.prueba.Vehiculo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.icc.prueba.Vehiculo.services.VehicleService;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.VehicleResponseDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.CreateVehicleDto;
import ec.edu.ups.icc.prueba.Vehiculo.dtos.PartialVehicleDto;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public VehicleResponseDto create(@RequestBody CreateVehicleDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody CreateVehicleDto dto) {
        return service.update(id, dto);
    }

    @PatchMapping("/{id}")
    public Object updatePartial(@PathVariable int id, @RequestBody PartialVehicleDto dto) {
        return service.updatePartial(id, dto);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable int id) {
        return service.delete(id);
    }
}
