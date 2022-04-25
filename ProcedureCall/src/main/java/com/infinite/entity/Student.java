package com.infinite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.sound.midi.Sequence;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Proxy(lazy = true)
public class Student {

    @Id
    /*@GeneratedValue(generator = "seq")
    @GenericGenerator(name = "seq",strategy = "org.hibernate.id.SequenceGenerator")*/
    @GeneratedValue(generator = "prod",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "prod",sequenceName = "PRODUCT_ID",initialValue = 1,allocationSize = 1)
    private Integer id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




}
