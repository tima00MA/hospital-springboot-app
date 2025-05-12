package ma.fs.hospital.repositories;

import ma.fs.hospital.entities.Consultation;
import ma.fs.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationReposiroty extends JpaRepository<Consultation, Long> {
}
