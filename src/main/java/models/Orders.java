/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex Christian
 */
@MapToTable("Order")
public class Orders implements Serializable {
    @PrimaryKey("order_id")
    @MapToColumn("order_id")
    private String orderID;
    @MapToColumn("ticket_number")
    private String ticketNumber;
    @MapToColumn("order_date")
    private long orderDate;
    @MapToColumn("promocode_promocode")
    private String promoCode;

    public Orders() {
    }

    public Orders(String orderID, String ticketNumber, long orderDate, String promoCode) {
        this.orderID = orderID;
        this.ticketNumber = ticketNumber;
        this.orderDate = orderDate;
        this.promoCode = promoCode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + 
                ", ticketNumber=" + ticketNumber + 
                ", orderDate=" + orderDate + 
                ", promoCode=" + promoCode + '}';
    } 
}
