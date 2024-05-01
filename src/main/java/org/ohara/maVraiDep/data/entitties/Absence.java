package org.ohara.maVraiDep.data.entitties;

import org.ohara.maVraiDep.data.enums.StatusAbsence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "absences")
public class Absence extends AbstractEntity {
    private Date dateAbsence;
    private LocalTime heureAbsence;
    private String motif;
    private StatusAbsence statusAbsence;
    @ManyToOne
    SessionCours sessionCours;
    @ManyToOne
    Etudiant etudiant;

}
