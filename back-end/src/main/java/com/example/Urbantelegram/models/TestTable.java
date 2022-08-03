package com.example.Urbantelegram.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_table")
public class TestTable {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer t_Id;


}
