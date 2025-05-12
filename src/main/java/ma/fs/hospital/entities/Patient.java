package ma.fs.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE) // pour n'a pas garder l'heur et les minutes
    private Date deteNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch=FetchType.LAZY)
    private Collection<RendezVous> rendezVous;



}
