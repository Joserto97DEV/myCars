package com.josalv.mycars;

//Clase que define un objeto coche

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.UUID;

public class Car {

    private final String id;
    private final String marca;
    private final String modelo;
    private final String tipo;
    private final String color;
    private final String descripcion;


    public Car(String marca, String modelo, String tipo, String color, String descripcion) {
        UUID id_aleatoria=UUID.randomUUID();

        this.id = id_aleatoria.toString();
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.color = color;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
