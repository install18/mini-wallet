package mini.wallet.monolith.model.base;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class BaseDataObject {
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDateTime;

    @Column(nullable = false)
    private LocalDateTime modifiedDateTime;
}
