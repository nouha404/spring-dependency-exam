package org.ohara.maVraiDep.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ETypeSession {
    EN_LIGNE(0),
    PRESENTIEL(1);
    private final long indexEnumEtat;
}
