package edu.upc.dsa;

import java.util.List;

public class OrderVO {

    String usuario;
    List<String> productList;


    public OrderVO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }
}
