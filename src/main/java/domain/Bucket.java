package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    private  String id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private  User user;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;

    @Column(name = "purchaseDate")
    private Date purchaseDate;

    public Bucket(){};

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", product=" + product +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
