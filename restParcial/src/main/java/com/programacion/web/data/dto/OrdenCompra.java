package com.programacion.web.data.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "orden_compra")
@Entity
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany(fetch = FetchType. EAGER)
    @JoinTable(
            name = "orden_compra_producto",
            joinColumns = @JoinColumn(name = "orden_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")

    )
    private List<Producto> productos;

    private double precio;




}
