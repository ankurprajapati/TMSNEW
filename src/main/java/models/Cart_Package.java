/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import java.io.Serializable;

/**
 *
 * @author Alex Christian
 */
@MapToTable("Cart_Package")
public class Cart_Package implements Serializable {
    @MapToColumn("cart_cart_id")
    private String cartID;
    @MapToColumn("package_package_id")
    private String packageID;

    public Cart_Package() {
    }

    public Cart_Package(String cartID, String packageID) {
        this.cartID = cartID;
        this.packageID = packageID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    @Override
    public String toString() {
        return "Cart_Package{" + "cartID=" + cartID + ", packageID=" + packageID + '}';
    }
    
}
