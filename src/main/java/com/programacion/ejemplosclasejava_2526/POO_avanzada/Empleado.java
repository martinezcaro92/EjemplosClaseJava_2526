/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada;

/**
 *
 * @author josem
 */
public class Empleado extends Persona {
    // Se definen los atributos propios de la clase Empleado
    private String numeroCuenta, puesto;
    
    // Se define un constructor vacío de la clase Empleado
    public Empleado ()
    {
        /*Esta palabra reservada hace mención al constructor vacío de la clase
            padre, en este caso de la clase Persona. Generaliza sin llamar al 
            constructor con el nombre propio
        */
        super();
        
    }
    
    // Se define un constructor completo de la clase Empleado.
    /* IMPORTANTE: Aquí no sólo se ponen los atributos de la clase hija, sino
        también los atributos de la clase padre. Se generaliza indicando los
        atributos de la clase padre primero y posteriormente los atributos de
        la clase hija después
    */
    public Empleado (String nombre, String apellido, String dni,
                        String numeroCuenta, String puesto)
    {
        /* Sería la misma palabra resevada (super) que en el constructor vacío, 
            pero en este caso llama al constructor completo definido en la 
            clase padre (Persona)
        */
        super(nombre, apellido, dni);
        this.numeroCuenta = numeroCuenta;
        this.puesto = puesto;
    }
    
    public String getNumeroCuenta ()
    {
        return numeroCuenta;
    }
    public void setNumeroCuenta (String numeroCuenta)
    {
        this.numeroCuenta = numeroCuenta;
    }
    public String getPuesto ()
    {
        return puesto;
    }
    public void setPuesto (String puesto)
    {
        this.puesto = puesto;
    }
    
    /* Este método reescribe el método getNombreCompleto() definido en la clase
        padre (Persona) con una nueva funcionalidad. Esto es una clave de la POO
        avanzada gracias al polimorfismo
    */
    @Override
    public String getNombreCompleto ()
    {
        return super.getApellido() + ", " + super.getNombre();
    }
    
    
}
