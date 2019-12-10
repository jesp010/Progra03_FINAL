/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import AccesoDatos.BaseDAO;
import AccesoDatos.ProductorasDAO;
import AccesoDatos.QuimicosDAO;
import AccesoDatos.ResiduosDAO;
import AccesoDatos.TransportadorasDAO;
import AccesoDatos.TrasladosDAO;
import ObjetosNegocio.Productora;
import ObjetosNegocio.Quimico;
import ObjetosNegocio.Residuo;
import ObjetosNegocio.Transportadora;
import ObjetosNegocio.Traslado;
import java.util.ArrayList;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        QuimicosDAO qdao = new QuimicosDAO();
        ResiduosDAO rdao = new ResiduosDAO();
        ProductorasDAO pdao = new ProductorasDAO();
        TransportadorasDAO tdao = new TransportadorasDAO();
        TrasladosDAO trdao = new TrasladosDAO();
//        for(int i = 0; i < 50; i++){
//            
//            qdao.insertOne(new Quimico("Quimico " + i));
//        }
//        
//        for(Quimico q: qdao.findAll()){
//            System.out.println(q.toString());
//        }
//        ArrayList<Quimico> quimicos = qdao.findAll();
//        ArrayList<Quimico> qr = new ArrayList<>();
//        qr.add(quimicos.get(0));
//        qr.add(quimicos.get(1));
//        qr.add(quimicos.get(3));
//        qr.add(quimicos.get(4));
//        qr.add(quimicos.get(5));
//        qr.add(quimicos.get(6));
//        
//        
//        pdao.insertOne(new Productora("Quimicos Noroeste", "200 y tabasco 86123","2131233"));
//        Productora p1 = pdao.findAll().get(0);
//        rdao.insertOne(new Residuo("Residuo Test 3", 2000.0f, p1, qr));
//        
//        ArrayList<Residuo> residuos = rdao.findAll();
//        for(Residuo r: residuos){
//            System.out.println(r.toString());
//        }

          tdao.insertOne(new Transportadora("Transportadora Residuos", "Nainari y California 84129", "6442546576"));
          Residuo re = rdao.findAll().get(1);
          Transportadora tra = tdao.findAll().get(0);
          trdao.insertOne(new Traslado(re, "Navojoa", "Obregon", new Date(2019 - 1900, 03, 23), new Date(2019 - 1900, 03, 25), "Purificacion", tra, "terrestre" ));
        
        Traslado tras = trdao.findAll().get(0);
        System.out.println(tras.toString());

    }
}
