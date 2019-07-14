/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.Database;
import dao.GenericDAO;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Alex Christian
 */
public class Main extends Application {
    
    static{
    
    GenericDAO.addAnnotatedClass(Aircraft.class);
        GenericDAO.addAnnotatedClass(Airline.class);
        GenericDAO.addAnnotatedClass(Airline_Aircraft.class);
        GenericDAO.addAnnotatedClass(Cart.class);
        GenericDAO.addAnnotatedClass(Cart_Flight.class);
        GenericDAO.addAnnotatedClass(Cart_Package.class);
        GenericDAO.addAnnotatedClass(FAQ.class);
        GenericDAO.addAnnotatedClass(Flight.class);
        GenericDAO.addAnnotatedClass(Hotel.class);
        GenericDAO.addAnnotatedClass(IATA.class);
        GenericDAO.addAnnotatedClass(Orders.class);
        GenericDAO.addAnnotatedClass(Orders_Packages.class);
        GenericDAO.addAnnotatedClass(Packages.class);
        GenericDAO.addAnnotatedClass(Packages_Flights.class);
        GenericDAO.addAnnotatedClass(PromoCode.class);
        GenericDAO.addAnnotatedClass(Survey.class);
        GenericDAO.addAnnotatedClass(SurveyQuestions.class);
        GenericDAO.addAnnotatedClass(Ticket.class);
        GenericDAO.addAnnotatedClass(Ticket_Flights.class);
        GenericDAO.addAnnotatedClass(User.class);
        GenericDAO.addAnnotatedClass(Aircraft.class);
        GenericDAO.generateMappings();
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
        
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        launch(args);
        GenericDAO.Condition c1 = GenericDAO.makeCondition("aircraft_model", GenericDAO.NOT_EQUALS, "777");
        GenericDAO.Condition c2 = GenericDAO.makeCondition("aircraft_model", GenericDAO.NOT_EQUALS, "test model");
        GenericDAO.Condition c3 = GenericDAO.makeCondition("aircraft_model", GenericDAO.EQUALS, "777");
        GenericDAO.Condition c4 = GenericDAO.makeCondition("aircraft_make", GenericDAO.EQUALS, "BOEING");
        //GenericDAO.Condition andCondition = GenericDAO.makeANDCondition(c1, c2);
        GenericDAO.Condition orCondition = GenericDAO.makeANDCondition(c3, c4);
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        
        
        conditions.add(orCondition);
        //conditions.add(andCondition);
        //conditions.add(c4);
        for (Object obj : GenericDAO.objects(Aircraft.class)) {
            System.out.println(obj.toString());
        }
        //System.out.println(GenericDAO.first(Aircraft.class, conditions).toString());
        System.out.println(GenericDAO.delete(Aircraft.class, new Aircraft("test modeljh", "test make5hggjg", 5, 11, 2900)) + " row(s) affected");
        System.exit(0);
    }
}
