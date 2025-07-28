package br.com.vhaporfiro.repository;

import br.com.vhaporfiro.entities.loan.LoanType;
import br.com.vhaporfiro.entities.loan.LoanTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {

    LoanType findByLoanTypeEnum(LoanTypeEnum loanTypeEnum);

}
