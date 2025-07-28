package br.com.vhaporfiro.entities.loan;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_type")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private LoanTypeEnum loanTypeEnum;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    public LoanType(){}

    public LoanType(LoanTypeEnum loanTypeEnum, BigDecimal interestRate) {
        this.loanTypeEnum = loanTypeEnum;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LoanTypeEnum getLoanTypeEnum() {
        return loanTypeEnum;
    }

    public void setLoanTypeEnum(LoanTypeEnum loanTypeEnum) {
        this.loanTypeEnum = loanTypeEnum;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
