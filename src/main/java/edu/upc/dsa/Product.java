package edu.upc.dsa;

import java.util.Comparator;

public class Product {

    private String product;
    private double price;
    private int cantidad;
    private int vendidos;

    public Product(){

    }

    public Product (String product, double price, int cantidad){
        this.product = product;
        this.price = price;
        this.cantidad = cantidad;
        this.vendidos = 0;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateCantidad(int q) {

        this.cantidad = cantidad - q;
        this.vendidos = vendidos + q;
    }

    public static final Comparator<? super Product> CMP_PRICE = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {

            return (int)(o1.price - o2.price);
        }
    };
    public static final Comparator<? super Product> CMP_SOLD = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {

            return (int)(o2.vendidos - o1.vendidos);
        }
    };
}
