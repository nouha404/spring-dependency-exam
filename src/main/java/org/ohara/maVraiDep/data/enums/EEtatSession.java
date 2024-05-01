package org.ohara.maVraiDep.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EEtatSession {
    VALIDER(0),
    INVALIDER(1);
    private final long indexEnumEtat;
}
