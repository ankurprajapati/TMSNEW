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
import javafx.scene.control.Button;

/**
 *
 * @author Alex Christian
 */
@MapToTable("Flight")
public class Flight implements Serializable{
    @PrimaryKey("flight_number")
    @MapToColumn("flight_number")
    private String flightNumber;
    //private String cartID;  
    @MapToColumn("departure_date")
    private Date departureDate;
    //private String packageID;
    @MapToColumn("arrival_date")
    private Date arrivalDate;
    @MapToColumn("departureIATA_IATACode")
    private String departureIATACode;
    @MapToColumn("arrivalIATA_IATACode")
    private String arrivalIATACode;
    @MapToColumn("airline_airline_id")
    private String airlineID;
    //private String ticketNumber;
    @MapToColumn("first_class_price")
    private double firstClassPrice;
    @MapToColumn("business_class_price")
    private double businessClassPrice;
    @MapToColumn("economy_price")
    private double economyPrice;
    @MapToColumn("isFull")
    private boolean isFull;
   

    public Flight() {
    }
    
    public Flight(String flightNumber, Date departureDate, Date arrivalDate, String departureIATACode, String arrivalIATACode, String airlineID, double firstClassPrice, double businessClassPrice, double economyPrice, boolean isFull) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureIATACode = departureIATACode;
        this.arrivalIATACode = arrivalIATACode;
        this.airlineID = airlineID;
        this.firstClassPrice = firstClassPrice;
        this.businessClassPrice = businessClassPrice;
        this.economyPrice = economyPrice;
        this.isFull = isFull;
    }
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureIATACode() {
        return departureIATACode;
    }

    public void setDepartureIATACode(String departureIATACode) {
        this.departureIATACode = departureIATACode;
    }

    public String getArrivalIATACode() {
        return arrivalIATACode;
    }

    public void setArrivalIATACode(String arrivalIATACode) {
        this.arrivalIATACode = arrivalIATACode;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public double getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(double businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departureDate=" + departureDate + 
                ", arrivalDate=" + arrivalDate + ", departureIATACode=" + departureIATACode + 
                ", arrivalIATACode=" + arrivalIATACode + ", airlineID=" + airlineID + 
                ", firstClassPrice=" + firstClassPrice + 
                ", businessClassPrice=" + businessClassPrice + 
                ", economyPrice=" + economyPrice + ", isFull=" + isFull + '}';
    }
    
}
