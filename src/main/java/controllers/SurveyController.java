/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.GenericDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import models.SurveyQuestions;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class SurveyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label q1, q2, q3, q4, q5;

    @FXML
    private RadioButton q1r1, q1r2, q1r3, q1r4, q1r5;

    @FXML
    private RadioButton q2r1, q2r2, q2r3, q2r4, q2r5;
    @FXML
    private RadioButton q3r1, q3r2, q3r3, q3r4, q3r5;
    @FXML
    private RadioButton q4r1, q4r2, q4r3, q4r4, q4r5;
    @FXML
    private RadioButton q5r1, q5r2, q5r3, q5r4, q5r5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();
        ToggleGroup group4 = new ToggleGroup();
        ToggleGroup group5 = new ToggleGroup();
        RadioButton[] buttons = new RadioButton[]{q1r1, q1r2, q1r3, q1r4, q1r5,
            q2r1, q2r2, q2r3, q2r4, q2r5,
            q3r1, q3r2, q3r3, q3r4, q3r5,
            q4r1, q4r2, q4r3, q4r4, q4r5,
            q5r1, q5r2, q5r3, q5r4, q5r5};
        for (int i = 0; i < buttons.length; i++) {
            if (i < 5) {
                buttons[i].setToggleGroup(group1);
            } else if (i < 10) {
                buttons[i].setToggleGroup(group2);
            } else if (i < 15) {
                buttons[i].setToggleGroup(group3);
            } else if (i < 20) {
                buttons[i].setToggleGroup(group4);
            } else {
                buttons[i].setToggleGroup(group5);
            }
        }
        //Toggle btn = group1.getSelectedToggle();
        //System.out.println(btn.getUserData());

        Label[] labels = new Label[]{q1, q2, q3, q4, q5};
        // TODO

        try {
            List<Object> questions = GenericDAO.objects(SurveyQuestions.class);
            int i = 0;
            for (Object question : questions) {
                SurveyQuestions q = (SurveyQuestions) question;
                labels[i].setText(q.getQuestion());
                if (i == 5) {
                    break;
                }
                i++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    public void submit() throws Exception {
        
        
    }
}
