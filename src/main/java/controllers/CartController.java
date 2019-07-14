/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.GenericDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import models.Cart;
import repositories.CartRepository;
import commons.Common;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cart_Flight_Order;
import models.Cart_Packages_Order;
import models.Flight;
import models.Packages;
/**
 * FXML Controller class
 *
 * @author gargi
 */
public class CartController implements Initializable {
      
    @FXML
    private Label lblMyCart;
    @FXML
    private TitledPane titledPaneFlights;
    @FXML
    private TitledPane titledPanePackage;
    @FXML
    private Label lblTotal;
    @FXML
    private TextField txtTotal;
    @FXML
    private Button btnContinue;
    @FXML
    private TableView tblFlights;
    @FXML
    private TableView tblPackage;
    @FXML
    private TableColumn colFlight;
    @FXML
    private TableColumn colDeparture;
    @FXML
    private TableColumn colArrival;
    @FXML
    private TableColumn colDepartureTime;
    @FXML
    private TableColumn colArrivalTime;
    @FXML
    private TableColumn colTotal;
    @FXML
    private TableColumn colRemove;
     @FXML
    private TableColumn colPackageName;
    @FXML
    private TableColumn colPackageDays;
    @FXML
    private TableColumn colPackageTotal;
    @FXML
    private TableColumn colPackageRemove;
  
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try
       {
          // List<Flight> flights = CartRepository.getFlights(Common.LOGGED_IN_USERID); 
           List<Cart_Flight_Order> cart_flights = CartRepository.getCartFlights(Common.LOGGED_IN_USERID);  
           double total = 0.0;
           
           if (!cart_flights.isEmpty()) {
               for(Cart_Flight_Order cart_flight:cart_flights)
           {
               total+=cart_flight.getEconomyPrice();
           }
               
               ObservableList<Cart_Flight_Order> flightData = FXCollections.observableArrayList(cart_flights);
               colFlight.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("flightNumber"));
               colDeparture.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("departureIATACode"));
               colArrival.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("arrivalIATACode"));
               colDepartureTime.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("departureDate"));
               colArrivalTime.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("arrivalDate"));
               colTotal.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("economyPrice"));
               colRemove.setCellValueFactory(new PropertyValueFactory<Cart_Flight_Order,String>("removeBtn"));
               tblFlights.setItems(flightData);
               tblFlights.getColumns().addAll(colFlight,colDeparture,colArrival,colDepartureTime,colArrivalTime,colTotal,colRemove);
           
          
           }
           
            List<Cart_Packages_Order> cartPackages = CartRepository.getCartPackages(Common.LOGGED_IN_USERID);
            if (!cartPackages.isEmpty()) {
            for(Cart_Packages_Order cartPackage:cartPackages)
           {
               total+=cartPackage.getPackagePrice();
           }
              ObservableList<Cart_Packages_Order> packageData = FXCollections.observableArrayList(cartPackages);
              colPackageName.setCellValueFactory(new PropertyValueFactory<Cart_Packages_Order,String>("packageName"));
               colPackageDays.setCellValueFactory(new PropertyValueFactory<Cart_Packages_Order,String>("packageDays"));
               colPackageTotal.setCellValueFactory(new PropertyValueFactory<Cart_Packages_Order,String>("packagePrice"));
               colPackageRemove.setCellValueFactory(new PropertyValueFactory<Cart_Packages_Order,String>("removeBtn"));
              
               tblPackage.setItems(packageData);
               tblPackage.getColumns().addAll(colPackageName,colPackageDays,colPackageTotal,colPackageRemove);
               txtTotal.setText(Double.toString(total));
              
               
           }
               
               
           }    
            catch (Exception ex)
            {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
          
          
           
       
       
       
        // TODO
    }  
   
    
   @FXML
     public void checkout(ActionEvent evt) throws Exception  {
         Parent chckoutView = FXMLLoader.load(getClass().getResource("/fxml/Checkout.fxml"));
         Scene s = new Scene(chckoutView);
         Stage window =(Stage)((Node)evt.getSource()).getScene().getWindow();
         window.setScene(s);
         window.show();
         
     }
    
}
