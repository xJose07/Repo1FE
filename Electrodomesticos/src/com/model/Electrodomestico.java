package com.model;

public class Electrodomestico {

    private final String colorDefault="blanco";
    private final char consumoEnergeticoDefault='F';
    private final float precioBaseDefault=100.0f;
    private final float pesoDefault=5.0f;
    
    private float precioBase=precioBaseDefault;
    private String color=colorDefault;
    private char consumoEnergetico=consumoEnergeticoDefault;
    private float peso=pesoDefault;
   
    
    public Electrodomestico(){}
    public Electrodomestico(float precioBase,float peso){
        this.precioBase=precioBase;
        this.peso=peso;
    }
    public Electrodomestico(float precioBase,String color,char consumoEnergetico,float peso){
        if(comprobarConsumoEnergetico(consumoEnergetico)){
            this.consumoEnergetico=consumoEnergetico;
        }
        if(comprobarColor(color)){
            this.color=color;
        }
        this.precioBase=precioBase;  
        this.peso=peso;
    }

    public float getPrecioBase() {
        return precioBase;
    }
    public String getColor() {
        return color;
    }
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    public float getPeso() {
        return peso;
    }
    
    private boolean comprobarConsumoEnergetico(char letra){
        boolean valid;
        valid = letra=='A' ||
                letra=='B' ||
                letra=='C' ||
                letra=='D' ||
                letra=='E' ||
                letra=='F';
        
        return valid;
    }

    private boolean comprobarColor(String color){
        boolean valid;
        color=color.toUpperCase();
        valid = color.equals("ROJO")||
                color.equals("BLANCO")||
                color.equals("NEGRO")||
                color.equals("AZUL")||
                color.equals("GRIS");   
        return valid;
    }

    private float precioConsumoEnergetico(){
        float out=0.0f;
        switch(this.getConsumoEnergetico()){
            case 'A':
                out=100.0f;
                break;
            case 'B':
                out=80.0f;
                break;
            case 'C':
                out=60.0f;
                break;
            case 'D':
                out=50.0f;
                break;
            case 'E':
                out=30.0f;
                break;
            default:
                out=10.0f;
        }
        return out;
    }
    
    private float precioPeso(){
        float out=0.0f;
        if(this.getPeso()>=0 && this.getPeso()<=19){
            out=10.0f;
        }
        else if(this.getPeso()>19 && this.getPeso()<=49){
            out=50.0f;
        }
        else if(this.getPeso()>49 && this.getPeso()<=79){
            out=80.0f;
        }
        else{
            out=100.0f;
        }
        return out;
    }

    public float precioFinal(){
        return this.precioConsumoEnergetico()+this.precioPeso();
    }
    
    @Override
    public String toString() {
        return "Electrodomestico [precioBase=" + precioBase + ", color=" + color + ", consumoEnergetico="
                + consumoEnergetico + ", peso=" + peso + "]";
    }
}
