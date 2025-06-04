package com.tecdesoftware.market.persistence;
import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;
import java.util.List;

public class ProductoRepository
{
    private ProductoCrudRepository productoCrudRepository;

    //Equivalente a poner SELECT * FROM productos
    public List<Producto> getAll() {
        //Se castea de iterable a lista
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
