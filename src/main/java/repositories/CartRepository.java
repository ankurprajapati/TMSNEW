/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositories;

import dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import models.Cart;
import models.Flight;
import models.Cart_Flight;
import models.Cart_Flight_Order;
import models.Cart_Package;
import models.Cart_Packages_Order;
import models.Packages;

/**
 *
 * @author Alex Christian
 */
public class CartRepository {
     public static List<Cart_Flight_Order> getCartFlights(String userID)throws Exception{
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Cart cart = (Cart)GenericDAO.first(Cart.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("cart_cart_id", GenericDAO.EQUALS, cart.getCartId()));
        List<Object> cart_flight = GenericDAO.objects(Cart_Flight.class, conditions);
        List<Flight> flights = new ArrayList<>();
        List<Cart_Flight_Order> cfos = new ArrayList<>();
        for(Object cf : cart_flight){
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("flight_number", GenericDAO.EQUALS, ((Cart_Flight)cf).getFlightID()));
            flights.add((Flight)GenericDAO.first(Flight.class, conditions));
           }
         
         for(Flight f : flights)
         {
             Cart_Flight_Order cfo = new Cart_Flight_Order();
             cfo.setFlightNumber(f.getFlightNumber());
             cfo.setArrivalDate(f.getArrivalDate());
             cfo.setDepartureDate(f.getDepartureDate());
             cfo.setDepartureIATACode(f.getDepartureIATACode());
             cfo.setArrivalIATACode(f.getArrivalIATACode());
             cfo.setEconomyPrice(f.getEconomyPrice());
             cfo.setRemoveBtn(new Button("Remove"));
             cfos.add(cfo);
         }
        return cfos;
    }
    public static List<Flight> getFlights(String userID)throws Exception{
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Cart cart = (Cart)GenericDAO.first(Cart.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("cart_cart_id", GenericDAO.EQUALS, cart.getCartId()));
        List<Object> cart_flight = GenericDAO.objects(Cart_Flight.class, conditions);
        List<Flight> flights = new ArrayList<>();
        for(Object cf : cart_flight){
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("flight_number", GenericDAO.EQUALS, ((Cart_Flight)cf).getFlightID()));
            flights.add((Flight)GenericDAO.first(Flight.class, conditions));
           }
        return flights;
    }
    public static List<Packages> getPackages(String userID)throws Exception{
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Cart cart = (Cart)GenericDAO.first(Cart.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("cart_cart_id", GenericDAO.EQUALS, cart.getCartId()));
        List<Object> cart_package = GenericDAO.objects(Cart_Package.class, conditions);
        List<Packages> packages = new ArrayList<>();
        for(Object cp : cart_package){
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("package_id", GenericDAO.EQUALS, ((Cart_Package)cp).getPackageID()));
            packages.add((Packages)GenericDAO.first(Packages.class, conditions));
        }
        return packages;
    } 
     public static List<Cart_Packages_Order> getCartPackages(String userID)throws Exception{
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Cart cart = (Cart)GenericDAO.first(Cart.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("cart_cart_id", GenericDAO.EQUALS, cart.getCartId()));
        List<Object> cart_package = GenericDAO.objects(Cart_Package.class, conditions);
        List<Packages> packages = new ArrayList<>();
        List<Cart_Packages_Order> cartPackages = new ArrayList<>();
        for(Object cp : cart_package){
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("package_id", GenericDAO.EQUALS, ((Cart_Package)cp).getPackageID()));
            packages.add((Packages)GenericDAO.first(Packages.class, conditions));
        }
        Cart_Packages_Order cpo = new Cart_Packages_Order();
        for(Packages p : packages)
        {
            cpo.setPackageName(p.getPackageName());
            cpo.setPackageID(p.getPackageID());
            cpo.setPackageDays(p.getPackageDays());
            cpo.setPackagePrice(p.getPackagePrice());
            cpo.setHotelID(p.getHotelID());
            cpo.setRemoveBtn(new Button("Remove"));
            cartPackages.add(cpo);
        }
        return cartPackages;
    }
}
