package com.example.web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Userone
{
    @Id
    int id;
    String name;

    String password;
    }
