package org.ohara.maVraiDep.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Specialiter {
    INFORMATIQUE(0),
    MATHS(1),
    ANGULAR(2),
    JAVA(3),
    MARKETING(4),
    PYTHON(5),
    PHILOSOPHIE(6);
    private final long indexEnumEtat;
}
