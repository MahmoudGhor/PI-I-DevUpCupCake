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
    private float price;
    private Date addedDate;
    private int patissierId;
    private String unite;

    public Product(int productId, String productName, String description, String pictures, boolean available, String type, float price,String unite, Date addedDate, int patissierId) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
        this.unite=unite;
        this.addedDate = addedDate;
        this.patissierId = patissierId;
    }


    

    public Product(String productName, String description, String pictures, boolean available, String type, 
            float price ,String unite) {
        this.productName = productName;
        this.description = description;
        this.pictures = pictures;
        this.available = available;
        this.type = type;
        this.price = price;
        this.unite=unite;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getPatissierId() {
        return patissierId;
    }

    public void setPatissierId(int patissierId) {
        this.patissierId = patissierId;
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
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", description=" + description + ", pictures=" + pictures + ", available=" + available + ", type=" + type + ", price=" + price + '}';
    }
    
    
    
    
    
    
    
    
}
