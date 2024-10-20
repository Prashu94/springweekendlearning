package io.spring.learning.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account Information"
)
public class AccountsDto {

    @NotEmpty(message = "AccountNumber cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber should be 10 digits")
    @Schema(
            description = "Account Number of Eazy Bank Account", example = "3456789876"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType cannot be null or empty")
    @Schema(
            description = "Account Type of Eazy Bank Account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress cannot be null or empty")
    @Schema(
            description = "Branch Address of Eazy Bank Account", example = "Bangalore"
    )
    private String branchAddress;

}
