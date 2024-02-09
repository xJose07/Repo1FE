package com.model;

public class Tostadora extends Electrodomestico{
    private final int slotsDefault=1;
    private int slot=slotsDefault;
    
    public Tostadora(){}
    public Tostadora(float precioBase,float peso){
        super(precioBase,peso);
    }
    public Tostadora(
            int slot,
            float precioBase,
            String color,
            char consumoEnergetico,
            float peso){
        super(precioBase,color,consumoEnergetico,peso);
        this.slot=slot;
    }

    public float getSlot() {
        return slot;
    }

    @Override
    public float precioFinal(){
        float out;
        if(this.getSlot()>2){
            out=25.0f+super.precioFinal();
        }
        else out= super.precioFinal();
     
        return out;
    }
}


