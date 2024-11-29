package co.edu.udea.arqui.parcial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero")
    private Integer numero;

    @JoinColumn(name = "cliente")
    @ManyToOne
    private Cliente cliente;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora_pedido")
    private Calendar horaPedido;

    @Column(name = "estado")
    private String estado;

    @Column(name = "hora_entrega")
    private Calendar horaEntrega;

}

