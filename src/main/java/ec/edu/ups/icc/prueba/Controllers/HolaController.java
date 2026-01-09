package ec.edu.ups.icc.prueba.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HolaController {

    @GetMapping("/status")
        public Map<String, Object> getStatus() {
        return Map.of("service", "up" 
        , "status", "running", "timestamp", System.currentTimeMillis()

        );
        }
    }
    


