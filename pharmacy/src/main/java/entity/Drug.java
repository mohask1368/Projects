package entity;


import javax.persistence.*;

@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;
    private String useCase;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }

    @Override
    public String toString() {
        return "  کد = " + id + "\n" + "  نام =" + name + "\n" + "  قیمت =" + price + "\n" + "  موارد مصرف =" + useCase;
    }
}
