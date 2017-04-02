package com.hrevfdz.reports;

import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.models.StockProducto;
import com.hrevfdz.services.IPharmacy;

public class Main {

    public static void main(String[] args) {
        IPharmacy<StockProducto> daoS = new StockProductoDAO();
//        StockProducto sp = new StockProducto();
        try {
            String q="SELECT t FROM StockProducto t WHERE t.codStock = 6";
            String q2="SELECT COUNT(s) FROM StockProducto s";
            StockProducto sp = daoS.findBy(q);
            if (sp != null) {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Cod Stock: " + sp.getCodStock());
                System.out.println("Producto: " + sp.getNombre());
            } else {
                System.out.println("No se encontró el medicamento que busca");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

}
