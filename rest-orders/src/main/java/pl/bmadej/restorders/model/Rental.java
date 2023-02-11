package pl.bmadej.restorders.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "rental", indexes = {
        @Index(name = "idx_fk_inventory_id", columnList = "inventory_id"),
        @Index(name = "idx_unq_rental_rental_date_inventory_id_customer_id", columnList = "rental_date, inventory_id, customer_id", unique = true)
})
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Integer id;

    @Column(name = "rental_date", nullable = false)
    private OffsetDateTime rentalDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "return_date")
    private OffsetDateTime returnDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(OffsetDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OffsetDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(OffsetDateTime returnDate) {
        this.returnDate = returnDate;
    }

}