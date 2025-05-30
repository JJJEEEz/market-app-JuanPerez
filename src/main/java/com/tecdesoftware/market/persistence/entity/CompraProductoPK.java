package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

//Para unir las 2 llaves y crear una llave compuesta
//Serializable es para que sea autoincrementable
@Embeddable
public class CompraProductoPK implements Serializable {

    @Column(name="id_compra")
    private int idCompra;

    @Column(name="id_producto")
    private int idProducto;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
