package br.com.vhaporfiro.repository;

import br.com.vhaporfiro.entities.client_loan.ClientLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientLoanRepository extends JpaRepository<ClientLoan, Long> {

    List<ClientLoan> findByClientId(Long clientId);

}
