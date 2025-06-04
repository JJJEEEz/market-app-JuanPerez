package com.tecdesoftware.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra
{
    @Id //Es la llave primaria
    //Autogenera ids autoincrementables
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int idProducto;
    @Column(name="id_cliente")
    private int idCliente;
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
