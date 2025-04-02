package com.elyxor.onboarding;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.UUID;

@Entity(name="order")
@Table(name = "ORDERS", schema = "PUBLIC")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Column(name = "TICKER", nullable = false, length=5)
    private String ticker;

    @Column(name="TRANSACTION",unique = true,nullable = false,length = 36)
    private String transaction = UUID.randomUUID().toString();

    @Column(name="ORDER_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    public Date getOrderTime() {return this.orderTime;}

    @Column(name="QUANTITY",nullable = false)
    private int quantity;

    @Column(name="PRICE",nullable = false)
    private float price;

    @Column(name="DIRECTION",nullable = false)
    @Enumerated(EnumType.STRING)
    private Direction direction;

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
