package com.example.Urbantelegram.models;

import javax.persistence.*;



@Entity
@Table(name = "TestTable")
public class testTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer t_Id;

}
