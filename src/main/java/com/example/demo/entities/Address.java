package com.example.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String geo_lat;
    private String geo_lng;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Embedded
    public Geo getGeo() {
        Geo geo = new Geo();
        geo.lat = geo_lat;
        geo.lng = geo_lng;
        return geo;
    }

    public void setGeo(Geo geo)
    {
        this.geo_lat = geo.lat;
        this.geo_lng = geo.lng;
    }
}

@Embeddable
class Geo {
    public String lat;
    public String lng;
}
