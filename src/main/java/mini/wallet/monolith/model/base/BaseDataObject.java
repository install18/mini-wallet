package mini.wallet.monolith.model.base;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDataObject {
    @Column(updatable = false)
    @NotBlank
    private LocalDateTime createdDateTime;

    @NotBlank
    private LocalDateTime modifiedDateTime;
}
