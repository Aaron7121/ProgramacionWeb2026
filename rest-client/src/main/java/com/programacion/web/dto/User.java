package com.programacion.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private String username;

    private String email;

    private String addressStreet;

    private String addressSuite;

    private String addressCity;

    private String addressZipcode;

    private BigDecimal addressGeoLat;

    private BigDecimal addressGeoLng;

    private String phone;

    private String website;

    private String companyName;

    private String companyCatchPhrase;

    private String companyBs;



}