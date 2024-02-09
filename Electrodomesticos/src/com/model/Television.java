package com.model;

public class Television extends Electrodomestico{ 
    private final float resolucionDefault=20.0f;
    private final boolean sintonizadorTDTDefault=false;
    
    private float resolucion=resolucionDefault;
    private boolean sintonizadorTDT=sintonizadorTDTDefault;
   
    public Television(){}
    public Television(float precioBase,float peso){
        super(precioBase,peso);
    }
    public Television(
            float resolucion,
            boolean sintonizadorTDT,
            float precioBase,
            String color,
            char consumoEnergetico,
            float peso){
        super(precioBase,color,consumoEnergetico,peso);
        this.resolucion=resolucion;
        this.sintonizadorTDT=sintonizadorTDT;
    }

    public float getResolucion() {
        return resolucion;
    }
    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public float precioFinal(){
        float out=super.precioFinal();
        if(this.getResolucion()>40){
            out+=super.precioFinal()*0.3f;
        }
        if(this.isSintonizadorTDT()){
             out+=50.0f;
        }
             
        return out;
    }
}
