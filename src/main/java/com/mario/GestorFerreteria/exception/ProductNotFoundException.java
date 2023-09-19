package com.mario.GestorFerreteria.exception;


//Gestiona la excepcion al no encontrar un producto
public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }

}
