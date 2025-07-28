package br.com.vhaporfiro.entities.client_loan;

import br.com.vhaporfiro.entities.client.Client;
import br.com.vhaporfiro.entities.loan.LoanType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_loan")
public class ClientLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @Column(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "loan_type_id", nullable = false)
    private LoanType loanType;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    public ClientLoan(){}

    public ClientLoan(Client client, LoanType loanType) {
        this.client = client;
        this.loanType = loanType;
        this.requestedAt = LocalDateTime.now();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }
}
