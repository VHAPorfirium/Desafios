package br.com.vhaporfiro.service;

import br.com.vhaporfiro.dto.ClientDTO;
import br.com.vhaporfiro.dto.LoanDetailsDTO;
import br.com.vhaporfiro.dto.LoanEligibilityResponseDTO;
import br.com.vhaporfiro.entities.client.StateCodeEnum;
import br.com.vhaporfiro.entities.loan.LoanType;
import br.com.vhaporfiro.entities.loan.LoanTypeEnum;
import br.com.vhaporfiro.repository.LoanTypeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanEligibilityService {

    private final LoanTypeRepository loanTypeRepository;

    public LoanEligibilityService(LoanTypeRepository loanTypeRepository) {
        this.loanTypeRepository = loanTypeRepository;
    }

    public LoanEligibilityResponseDTO checkLoanEligibility(ClientDTO clientDTO) {
        List<LoanDetailsDTO> eligibleLoans = new ArrayList<>();

        Optional<LoanType> personalLoanOpt = Optional.ofNullable(loanTypeRepository.findByLoanTypeEnum(LoanTypeEnum.PERSONAL));
        Optional<LoanType> consignmentLoanOpt = Optional.ofNullable(loanTypeRepository.findByLoanTypeEnum(LoanTypeEnum.CONSIGNMENT));
        Optional<LoanType> guaranteedLoanOpt = Optional.ofNullable(loanTypeRepository.findByLoanTypeEnum(LoanTypeEnum.GUARANTEED));

        BigDecimal personalInterestRate = personalLoanOpt.map(LoanType::getInterestRate).orElse(BigDecimal.ZERO);
        BigDecimal consignmentInterestRate = consignmentLoanOpt.map(LoanType::getInterestRate).orElse(BigDecimal.ZERO);
        BigDecimal guaranteedInterestRate = guaranteedLoanOpt.map(LoanType::getInterestRate).orElse(BigDecimal.ZERO);

        if (clientDTO.getIncome().compareTo(BigDecimal.valueOf(3000.00)) <= 0) {
            eligibleLoans.add(new LoanDetailsDTO(LoanTypeEnum.PERSONAL, personalInterestRate));
        }

        if (clientDTO.getIncome().compareTo(BigDecimal.valueOf(3000.00)) > 0 &&
                clientDTO.getIncome().compareTo(BigDecimal.valueOf(5000.00)) <= 0 &&
                clientDTO.getAge() < 30 &&
                clientDTO.getLocation() == StateCodeEnum.SP) {
            if (!eligibleLoans.stream().anyMatch(loan -> loan.getType() == LoanTypeEnum.PERSONAL)) {
                eligibleLoans.add(new LoanDetailsDTO(LoanTypeEnum.PERSONAL, personalInterestRate));
            }
        }

        if (clientDTO.getIncome().compareTo(BigDecimal.valueOf(5000.00)) >= 0) {
            eligibleLoans.add(new LoanDetailsDTO(LoanTypeEnum.CONSIGNMENT, consignmentInterestRate));
        }

        if (clientDTO.getIncome().compareTo(BigDecimal.valueOf(3000.00)) <= 0) {
            eligibleLoans.add(new LoanDetailsDTO(LoanTypeEnum.GUARANTEED, guaranteedInterestRate));
        }

        if (clientDTO.getIncome().compareTo(BigDecimal.valueOf(3000.00)) > 0 &&
                clientDTO.getIncome().compareTo(BigDecimal.valueOf(5000.00)) <= 0 &&
                clientDTO.getAge() < 30 &&
                clientDTO.getLocation() == StateCodeEnum.SP) {
            if (!eligibleLoans.stream().anyMatch(loan -> loan.getType() == LoanTypeEnum.GUARANTEED)) {
                eligibleLoans.add(new LoanDetailsDTO(LoanTypeEnum.GUARANTEED, guaranteedInterestRate));
            }
        }

        LoanEligibilityResponseDTO response = new LoanEligibilityResponseDTO();
        response.setName(clientDTO.getName());
        response.setLoans(eligibleLoans);

        return response;
    }
}