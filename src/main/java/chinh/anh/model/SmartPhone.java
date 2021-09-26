package chinh.anh.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "smart_phones")
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//@NotBlank
//@Size(min = 3, max = 6)
    private String producer;
//@NotBlank
    private String model;
//@Max(100)
    private double price;
    public SmartPhone() {
    }
    public SmartPhone(Long id,
    String producer, String model,double price) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.price = price;
    }
//    public SmartPhone(Long id, String producer, String model, double price) {
//        this.id = id;
//        this.producer = producer;
//        this.model = model;
//        this.price = price;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
