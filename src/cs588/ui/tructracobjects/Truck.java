package cs588.ui.tructracobjects;

import java.util.List;

import cs588.ui.tructrac.Menu;

public class Truck 
{
public double miles;
public List<Menus> menu;
public List<Review> reviews;
public List<Tweets> tweets;
public double lat;
public double lng;
public String street;
public String city;
public String state;
public String zipcode;
public String name;
public String cuisine;
public float rating;
public String phonenumber;
public boolean status;
public boolean fav;
public Truck(List<Menus> menu, List<Review> reviews, List<Tweets> tweets, double lat, double lng, String street, String city, String state, String zipcode, String name, String cuisine, float rating, String phonenumber,boolean status)
{
this.menu=menu;
this.reviews=reviews;
this.tweets=tweets;
this.lat=lat;
this.lng=lng;
this.street=street;
this.city=city;
this.state=state;
this.zipcode=zipcode;
this.name=name;
this.cuisine=cuisine;
this.rating=rating;
this.phonenumber=phonenumber;
this.status=status;
}

}
