package ma.fs.hospital.repositories;

import ma.fs.hospital.entities.Patient;
import ma.fs.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousReposiroty extends JpaRepository<RendezVous, String> {
}
