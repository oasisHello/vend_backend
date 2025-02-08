package oasis.vend.generator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oasis.vend.common.core.domain.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Generator extends BaseEntity {
    private  Long id;
    private  String name;
}
