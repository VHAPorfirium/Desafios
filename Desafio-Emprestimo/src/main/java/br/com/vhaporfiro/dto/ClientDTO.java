package br.com.vhaporfiro.dto;

import br.com.vhaporfiro.entities.client.StateCodeEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ClientDTO {

    @NotNull(message = "A idade é obrigatoria.")
    @Min(value = 0, message = "A idade não pode ser negativa.")
    @Max(value = 120, message = "A idade máxima é 120 anos.")
    private Integer age;

    @NotBlank(message = "O CPF é obrigatorio.")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido. Use o formato 000.000.000-00")
    private String cpf;

    @NotBlank(message = "O nome é obrigatorio.")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotNull(message = "O salario é obrigatorio.")
    @DecimalMin(value = "0.00", message = "Renda não pode ser negativa")
    @Digits(integer = 15, fraction = 4, message = "Renda com formato inválido (máx. 15 dígitos inteiros, 4 decimais)")
    private BigDecimal income;

    @NotNull(message = "O código de área é obrigatorio.")
    private StateCodeEnum location;

    public ClientDTO(){}

    public ClientDTO(Integer age, String cpf, String name, BigDecimal income, StateCodeEnum location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "ClientDTO{" +
                "age=" + age +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", income=" + income +
                ", location=" + location +
                '}';
    }
}