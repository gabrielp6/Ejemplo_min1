package edu.upc.dsa;

import java.util.List;

public interface ProductManager {// Hola
    /*
        - Listado de productos ordenado (ascendentemente) por precio
        - Realizar un pedido (que puede estar formado por diferentes productos y en
        diferentes cantidades) por parte de un usuario identificado
        - Servir un pedido. Los servicios se realizan en orden de llegadas
        - Listado de pedidos de un usuario que ya hayan sido realizados
        - Listado de productos ordenado (descendentemente) por número de ventas
    */


    public List<Product> getProductByPrice();
    public void newOrder(Order o);
    public Order proccesOrder();
    public List<Order> getOrderByUser(String usuario);
    public List<Product> getProductBySales();

}
