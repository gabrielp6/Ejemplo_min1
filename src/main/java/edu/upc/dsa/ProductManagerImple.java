package edu.upc.dsa;

import java.util.*;
import org.apache.log4j.Logger;

public class ProductManagerImple implements ProductManager{
/*
    2.1 Elección de las estructuras de datos
    2.3 La fachada deberá implementarse como un Singleton.
    2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de
    LOG4J que muestre el valor de los parámetros al inicio de los métodos y
    al final. También debe contemplarse trazas de otros niveles (ERROR o
    FATAL)

 */

    public HashMap<String, User> users;
    Queue<Order> pendingOrders;
    List<Product> productList;
    final static Logger logger = Logger.getLogger(ProductManagerImple.class);

    private static ProductManagerImple singleton;

    private ProductManagerImple(){
        //Inicializar los valores del HashMap
        this.users = new HashMap<>();

        //Inicializar  la cola
        pendingOrders =new LinkedList<>();

        //Inicialisamos la lista de productos
        this.productList = new LinkedList<>();
    }
    //Clase getInstance, que te devuelve la instancia de nuestra clase
    public static ProductManagerImple getInstance(){
        if(singleton == null){//Si la instancia no existe, la creamos
            singleton = new ProductManagerImple();
        }

        return singleton;
    }
    //Retorna una lista ordenada de menor a mayor
    @Override
    public List<Product> getProductByPrice() {

        logger.info("Ordenated products list (higher to lower)");
        Collections.sort(this.productList, Product.CMP_PRICE);//Llama a la función static CMP_PRICE del producto
        //Arrays.sort();

        for(Product p: productList){
            logger.info("getProduct: "+ p.getProduct() + " Price: " + p.getPrice());
        }

        return productList ;
    }

    //Añade un pedido a la lista de pedidos
    @Override
    public void newOrder(Order o) {//Realizar pedido

        pendingOrders.add(o);
        User u = this.getUserById(o.getUsuario());
        u.addOrder(o);

        logger.info("Ordered products: " + o);
        logger.info(o);
    }

    @Override
    public Order proccesOrder() {//Servir orden

        Order o = this.pendingOrders.poll();//Poll lo que hace es devolver el objeto y luego elimina de la cola(primer objeto añadido)
        List<Order.LP> lps = o.listProducts();
        for (Order.LP lp: lps ){
            Product p = this.getProductByName(lp.p);
            p.updateCantidad(lp.q);
        }

        logger.info("Served order: " + o);

        return o;
    }

    private User getUserById(String id) {

        return users.get(id);
    }

    private Product getProductByName(String p) {

        for (Product pr:productList) {
            if(pr.getProduct() == p){
               return pr;
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrderByUser(String usuario) {//Listado de pedidos de un usuario que ya hayan sido realizados
        User u;
        //List<Order> o= new LinkedList<>();
        u = this.users.get(usuario);
        if (u == null){
            System.out.println("El usuario " + usuario + ", no existe");
        }
        else{
            logger.info("getOrderByUser("+ usuario + "): ");
            for(Order o:u.orders){
                logger.info("/n" + o);
            }
        }
        return (u != null? u.orders:null);
    }

    @Override
    public List<Product> getProductBySales() {
        logger.info("GetProductBySales");
        Collections.sort(this.productList, Product.CMP_SOLD);//Llama a la función static CMP_PRICE del producto
        //Arrays.sort();

        for(Product p: productList){
            logger.info("getProduct: "+ p.getProduct() + " Sold products" + p.getVendidos());
        }

        return productList ;
    }
    public void clear(){

        //this.users.clear();
        this.pendingOrders.clear();
        this.productList.clear();
    }
    //Añade un usuario
    public void addClient(String codigo, User u){

        users.put(codigo,u);

    }
    //Añade un producto
    public void addProducts(String product, double price, int cantidad){

        this.productList.add(new Product(product,price,cantidad));
    }
}
