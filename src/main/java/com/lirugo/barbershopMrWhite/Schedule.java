package com.lirugo.barbershopMrWhite;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer barberId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date day;

    //0 Not working time
    //1 Working time
    //2 Busy, has client
    @Column(columnDefinition = "integer default 0") private Integer h1m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h2m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h3m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h4m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h5m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h6m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h7m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h8m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h9m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h10m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h11m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h12m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h13m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h14m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h15m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h16m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h17m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h18m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h19m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h20m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h21m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h22m00 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h23m00 = 0;

    @Column(columnDefinition = "integer default 0") private Integer h1m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h2m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h3m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h4m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h5m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h6m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h7m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h8m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h9m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h10m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h11m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h12m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h13m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h14m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h15m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h16m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h17m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h18m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h19m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h20m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h21m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h22m30 = 0;
    @Column(columnDefinition = "integer default 0") private Integer h23m30 = 0;

}
