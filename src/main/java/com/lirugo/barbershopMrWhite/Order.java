package com.lirugo.barbershopMrWhite;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ordr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Barber barber;

    private String name;
    private String phone;

    private String day;
    private String time;
    private String reminder;

    @Column(length = 2048)
    private String comment;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
