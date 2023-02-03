package mini.wallet.monolith.dal.dataobject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mini.wallet.monolith.model.base.BaseDataObject;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`retrial_task`")
public class RetrialTaskDO extends BaseDataObject {
    @Id
    @Column(updatable = false)
    private String retrialTaskId;

    private String transactionId;

    private Integer count;

    private Integer max;

    private LocalDateTime nextExecution;
}
