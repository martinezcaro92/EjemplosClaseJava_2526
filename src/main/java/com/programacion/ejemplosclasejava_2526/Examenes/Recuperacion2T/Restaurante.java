/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Restaurante {
    private String nombre;
    private ArrayList <Plato> carta;
    private ArrayList <Mesa> mesas;
    
    public Restaurante (String nombre, ArrayList<Plato> carta, ArrayList<Mesa> mesas)
    {
        if (nombre == null || nombre.trim().isEmpty()) throw new DatosNoValidosException("El nombre del restaurante es incorrecto");
        if (carta == null || carta.isEmpty()) throw new DatosNoValidosException("La carta del restaurante es incorrecta");
        if (mesas == null || mesas.isEmpty()) throw new DatosNoValidosException("Las mesas del restuante no son válidas");
        this.nombre=nombre;
        this.carta = carta;
        this.mesas = mesas;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosNoValidosException("El nombre del restaurante es incorrecto");
        }

        this.nombre = nombre;
    }

    public void setCarta(ArrayList<Plato> carta) {
        if (carta == null || carta.isEmpty()) {
            throw new DatosNoValidosException("La carta del restaurante es incorrecta");
        }

        this.carta = carta;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        if (mesas == null || mesas.isEmpty()) {
            throw new DatosNoValidosException("Las mesas del restuante no son válidas");
        }
        this.mesas = mesas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Plato> getCarta() {
        return carta;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public Mesa buscarMesa(int numeroMesa) throws MesaNoDisponibleException
    {
        for(Mesa m : mesas)
        {
            if (m.getNumeroMesa() == numeroMesa)
            {
                return m;
            }
        }
        throw new MesaNoDisponibleException("La mesa " + numeroMesa + " no está disponible en el sistema");
    }
    
    public void mostrarInformacionMesas()
    {
        for(Mesa m : mesas)
        {
            System.out.println(m);
        }
    }

    @Override
    public String toString() {
        return "Restaurante{" + "nombre=" + nombre + ", carta=" + carta + ", mesas=" + mesas + '}';
    }
    
}
