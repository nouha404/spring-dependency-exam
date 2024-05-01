package org.ohara.maVraiDep.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusAbsence {
    JUSTIFIER(0),
    NON_JUSTIFIER(1);
    private final long indexEnumEtat;
}
