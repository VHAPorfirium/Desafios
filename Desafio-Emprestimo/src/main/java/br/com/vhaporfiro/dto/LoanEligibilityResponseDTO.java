package br.com.vhaporfiro.dto;

import java.util.List;

public class LoanEligibilityResponseDTO {

    private String name;

    private List<LoanDetailsDTO> loans;

    public LoanEligibilityResponseDTO(){}

    public LoanEligibilityResponseDTO(String name, List<LoanDetailsDTO> loans) {
        this.name = name;
        this.loans = loans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LoanDetailsDTO> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanDetailsDTO> loans) {
        this.loans = loans;
    }
}
