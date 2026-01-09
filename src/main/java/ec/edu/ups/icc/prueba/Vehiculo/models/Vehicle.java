
package ec.edu.ups.icc.prueba.Vehiculo.models;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;

    public Vehicle(int id, String brand, String model, Double price, Integer stock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
