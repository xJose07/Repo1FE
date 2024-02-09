import com.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Electrodomestico[] lista=new Electrodomestico[10];
        lista=MisFunciones.llenarLista(lista);
        //Electrodomestico e = MisFunciones.crearElectrodomestico();
        //System.out.println(e.toString());
        System.out.println(MisFunciones.mostrarPreciosFinalesDeCadaElectrodomestico(lista));
        System.out.println(MisFunciones.mostrarPrecioFinal(lista));
    }
}
