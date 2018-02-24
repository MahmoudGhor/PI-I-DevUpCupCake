/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.entities;

import java.sql.Date;

/**
 *
 * @author omri_
 */
public class Product {
    private int productId;
    private String productName;
    private String description;
    private String pictures;
    private boolean available;
    private String type;
    private int price;
    private Date addedDate;
    private String userName;
    private String unite;

    public Product(int productId, String productName, String description, String pictures,
            boolean available, String type, int price,String unite, Date addedDate, String userName) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
        this.unite=unite;
        this.addedDate = addedDate;
        this.userName = userName;
    }


    

    public Product(String productName, String description, String pictures, boolean available, String type, 
            int price ,String unite) {
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
        this.unite=unite;
    }
    
    public Product(String productName, String description, String pictures, boolean available, String type, 
            int price ,String unite,Date addedDate) {
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
        this.unite=unite;
        this.addedDate=addedDate;
    }
    
    


    public Product() {
    }

    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

  
    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite=unite;
    }
  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.productId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  productName +"     " + description + "     "+addedDate;
    }
    
    
    
    
    
    
    
    
}
