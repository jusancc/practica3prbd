package sol;

import model.Articulo;
import model.Cliente;
import model.ExcepcionDeAplicacion;

public class Practica3 {
    public static void main(String[] args) {
        Articulo a= null;
        Cliente b = null;
        GestorBD gbd = null;
        try {

            gbd = new GestorBD();
            a = gbd.getArticulo("Fag/133MO");
            System.out.println(a);

            b = gbd.getCliente("200006/01");
            System.out.println(b);

            // getListadoArticulos();

        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }

        //crearPedido();
    }

}
