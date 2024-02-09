import com.model.*;
import java.util.Scanner;

public abstract class MisFunciones {
    static Scanner sc = new Scanner(System.in);

    public static Electrodomestico[] llenarLista(Electrodomestico[] lista){
        lista[0]=new Electrodomestico();
        lista[1]=new Lavadora(70.0f,30.0f);
        lista[2]=new Lavadora(50.0f,10.0f);
        lista[3]=new Lavadora(23.0f,64.0f,"Blanco",'H',45.0f);
        lista[4]=new Lavadora(75.0f,32.0f,"gris",'A',200.0f);
    
        lista[5]=new Electrodomestico();
        lista[6]=new Television(35.0f,25.0f);
        lista[7]=new Television(76.0f,60.0f);
        lista[8]=new Television(55.0f,true,120.0f,"azUl",'B',100.0f);
        lista[9]=new Television(89.0f,false,400.0f,"NEGRO",'A',150.0f);
        
        return lista;
    }

    public static String mostrarPreciosFinalesDeCadaElectrodomestico(Electrodomestico[] lista){
        String out="";
        for(int i=0;i<lista.length;i++){
            if(lista[i] instanceof Lavadora){
                out+="Lavadora: "+lista[i].precioFinal()+" euros\n";   
            }
            else if(lista[i] instanceof Television){
                out+="TV: "+lista[i].precioFinal()+" euros\n";
            }
            else{
                out+="Electrodomestico: "+lista[i].precioFinal()+" euros\n";
            }
        }
        return out;
    }
    
    public static String mostrarPrecioFinal(Electrodomestico[] lista){
        float totalTV=0.0f;
        float totalLavadora=0.0f;
        float totalElectrodomesticos=0.0f;
        for(int i=0;i<lista.length;i++){
            if(lista[i] instanceof Lavadora){
                totalLavadora+=lista[i].precioFinal();
            }
            else if(lista[i] instanceof Television){
                totalTV+=lista[i].precioFinal();
            }
            totalElectrodomesticos+=lista[i].precioFinal();
        }
        return 
            String.format("Precio total Televisores: %.1f euros\n",totalTV)+
            String.format("Precio total Lavadoras: %.1f euros\n",totalLavadora)+
            String.format("Precio total Electrodomésticos: %.1f euros\n",totalElectrodomesticos);
    }

    public static Electrodomestico crearElectrodomestico(){
        boolean valid = true;
        float pBase = 0.0f;
        float peso = 0.0f;
        do{
            try{
                valid = true;
                System.out.println("Please provide a price.");
                pBase = sc.nextFloat();
            }catch(java.util.InputMismatchException ex){
                valid = false;
                System.out.println("Please provide correct price data (No letters).");
                sc.nextLine();
            }
        }while(!valid);
        valid = true;
        do{
            try{
                valid = true;
                System.out.println("Please provide a weight.");
                peso = sc.nextFloat();
                if(peso <= 0){
                    throw new Exception();
                }
            }catch(Exception ex){
                valid = false;
                System.out.println("Please provide correct weight data (Not negative).");
                sc.nextLine();

            }
        }while(!valid);
        Electrodomestico e = new Electrodomestico(pBase, peso);
        return e;
    }
}
