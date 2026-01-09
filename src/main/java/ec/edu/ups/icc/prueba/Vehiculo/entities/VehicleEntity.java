








package ec.edu.ups.icc.prueba.Vehiculo.entities;

import ec.edu.ups.icc.prueba.core.entities.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "vehicles")
public class VehicleEntity extends BaseModel {
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "deleted", nullable = false)
    private String deleted;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
