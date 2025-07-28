package br.com.vhaporfiro.controller;

import br.com.vhaporfiro.dto.ClientDTO;
import br.com.vhaporfiro.dto.LoanEligibilityResponseDTO;
import br.com.vhaporfiro.service.LoanEligibilityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoanEligibilityController {

    private final LoanEligibilityService loanEligibilityService;

    public LoanEligibilityController(LoanEligibilityService loanEligibilityService) {
        this.loanEligibilityService = loanEligibilityService;
    }

    @PostMapping
    public ResponseEntity<LoanEligibilityResponseDTO> checkEligibility(@Valid @RequestBody ClientDTO clientDTO) {

        LoanEligibilityResponseDTO response = loanEligibilityService.checkLoanEligibility(clientDTO);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}