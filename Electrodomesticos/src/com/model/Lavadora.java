package com.model;

public class Lavadora extends Electrodomestico{
    private final float cargaDefault=5.0f;
    private float carga=cargaDefault;
    
    public Lavadora(){}
    public Lavadora(float precioBase,float peso){
        super(precioBase,peso);
    }
    public Lavadora(
            float carga,
            float precioBase,
            String color,
            char consumoEnergetico,
            float peso){
        super(precioBase,color,consumoEnergetico,peso);
        this.carga=carga;
    }

    public float getCarga() {
        return carga;
    }

    @Override
    public float precioFinal(){
        float out;
        if(this.getCarga()>30){
            out=50.0f+super.precioFinal();
        }
        else out= super.precioFinal();
     
        return out;
    }
}
