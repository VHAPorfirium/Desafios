package br.com.vhaporfiro.dto;

import br.com.vhaporfiro.entities.loan.LoanTypeEnum;

import java.math.BigDecimal;

public class LoanDetailsDTO {

    private LoanTypeEnum type;

    private BigDecimal interestRate;

    public LoanDetailsDTO(){}

    public LoanDetailsDTO(LoanTypeEnum type, BigDecimal interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public LoanTypeEnum getType() {
        return type;
    }

    public void setType(LoanTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
