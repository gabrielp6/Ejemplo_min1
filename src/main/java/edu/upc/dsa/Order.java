package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class Order {

    public List<LP> orderedProducts;
    private String usuario;

    public Order(){
        orderedProducts = new LinkedList<>();
    }

    public String getUsuario() {

        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<LP> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<LP> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void addProduct(String p, int q){

        this.orderedProducts.add(new LP(p,q));
    }
    public List<LP> listProducts(){
        return orderedProducts;
    }

    protected class LP {
        protected final String p;
        protected final int q;

        public LP() {
            this.p = null;
            this.q = 0;
        }
        public LP(String p, int q) {
            this.p = p;
            this.q = q;
        }

        public String getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        public String toString(){

            return this.q +" "+ this.p;
        }
    }
    public String toString(){

        return this.usuario + this.listProducts();
    }
}
