package sol;

import model.*;

import java.util.GregorianCalendar;
import java.util.List;

public class Practica3 {
    public static void main(String[] args) {
        Articulo a= null;
        Cliente c = null;
        GestorBD gbd = null;
        try {

            gbd = new GestorBD();
            a = gbd.getArticulo("Fag/133MO");
            System.out.println(a);

            c = gbd.getCliente("200006/01");
            System.out.println(c);

            getListadoArticulos();

        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }

        crearPedido();
    }

    public static void getListadoArticulos() throws ExcepcionDeAplicacion {

        Articulo a = null;
        GestorBD gbd = null;
        int i = 0;

        gbd = new GestorBD();
        List<String> articulos = gbd.getArticulos();

        try{
            for(String articulo : articulos){
                a = gbd.getArticulo(articulo);
                System.out.println(a);
                System.out.println(i);
                i++;
            }

        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }
    }

    public static void crearPedido(){

        GestorBD gbd = null;
        gbd = new GestorBD();
        GregorianCalendar fecha = new GregorianCalendar(2022, 3, 1, 12, 0, 0);

        try {
            Cliente c = gbd.getCliente("210010/02");
            PedidoEnRealizacion pr = new PedidoEnRealizacion("pedido6b", c, fecha);

            Articulo articulo1 = gbd.getArticulo("Fag/283FO");
            LineaEnRealizacion linea1 = new LineaEnRealizacion("linea1", pr , articulo1, 2, fecha);

            Articulo articulo2 = gbd.getArticulo("Fag/221LV");
            LineaEnRealizacion linea2 = new LineaEnRealizacion("linea2", pr, articulo2, 3, fecha);

            pr.addLinea(linea1);
            pr.addLinea(linea2);

            System.out.println(pr);

            Pedido p = new Pedido(pr);

            System.out.println(p);

        } catch (ExcepcionDeAplicacion e) {
            e.printStackTrace();
        }
    }
}
