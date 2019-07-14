/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author Alex Christian
 */
public class UserRepository {

    public static boolean registerUser(User client) {
        if (GenericDAO.save(User.class, client) == 0) {
            return false;
        }
        return true;
    }

    public static User getClient(String userID) {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        return (User) GenericDAO.first(User.class, conditions);
    }

}
