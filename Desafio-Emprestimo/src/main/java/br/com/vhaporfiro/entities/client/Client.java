package br.com.vhaporfiro.entities.client;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, precision = 15, scale = 4)
    private BigDecimal income;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
    private StateCodeEnum location;

    public Client(){}

    public Client(String cpf, String name, Integer age, BigDecimal income, StateCodeEnum location) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.income = income;
        this.location = location;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public StateCodeEnum getLocation() {
        return location;
    }

    public void setLocation(StateCodeEnum location) {
        this.location = location;
    }
}
