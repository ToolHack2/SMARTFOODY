package com.example.user.smartfoody.Model;

/**
 * Created by User on 1/1/2018.
 */

public class Produces {
    private Integer Image;
    private String Name;
    private String Price;

    public Produces(){}

    public Produces(Integer image, String name, String price)
    {
        this.Image = image;
        this.Name = name;
        this.Price = price;
    }
    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String value) {
        Price = value;
    }
}
