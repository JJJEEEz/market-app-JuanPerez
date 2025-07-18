package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra
{
    @Id //Es la llave primaria
    @Column(name="id_compra")
    //Autogenera ids autoincrementables
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCompra;
    @Column(name="id_producto")
    private Integer idProducto;
    @Column(name="id_cliente")
    private Integer idCliente;
    private LocalDateTime fecha;
    @Column(name="medio_pago")
    private String medioPago;
    private String comentario;
    private String estado;

    //Relación con Cliente: Muchas compras para un cliente
    @ManyToOne
    //Insertable/Updatable en false es para que no haya modificaciones
    @JoinColumn(name="id_cliente", insertable=false, updatable=false)
    private Cliente cliente;

    //Una compra tiene muchos productos
    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto()  {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getActivo() {
        return estado;
    }

    public void setActivo(String activo) {
        this.estado = activo;
    }
}
