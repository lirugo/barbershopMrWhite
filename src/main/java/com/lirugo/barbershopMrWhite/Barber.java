package com.lirugo.barbershopMrWhite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "barber")
@AllArgsConstructor
@NoArgsConstructor
public class Barber {
    @Id
    private Integer id;
    private String name;
}
