package org.ohara.maVraiDep.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatCours {
    TERMINER(0),
    EN_COURS(1);
    private final long indexEnumEtat;
}



