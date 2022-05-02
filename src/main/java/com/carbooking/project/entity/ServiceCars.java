package com.carbooking.project.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true, allowSetters = true)
@Table(name = "servicecars")

public class ServiceCars extends AuditModel implements Serializable
{

        private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_model", nullable = false)
    private String carModel;

    @Column(name = "car_type")
    private String carType;


    @Column(name = "car_seater")
    private int CarSeater;

    @Column(name = "city_name")
    private String cityName;


    @Column(name = "city_name1")
    private String cityName1;

    @Column(name = "city_name2")
    private String cityName2;



    @Column(name = "car_Colour")
    private String cityColor;






    @Column(name = "car_mileage")
    private String citymileage;






    @Column(name = "city_name")
    private String CITY ;



}
