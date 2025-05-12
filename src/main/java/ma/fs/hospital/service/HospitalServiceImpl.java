package ma.fs.hospital.service;

import jakarta.transaction.Transactional;
import ma.fs.hospital.entities.Consultation;
import ma.fs.hospital.entities.Medecin;
import ma.fs.hospital.entities.Patient;
import ma.fs.hospital.entities.RendezVous;
import ma.fs.hospital.repositories.ConsultationReposiroty;
import ma.fs.hospital.repositories.MedecinReposiroty;
import ma.fs.hospital.repositories.PatientReposiroty;
import ma.fs.hospital.repositories.RendezVousReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientReposiroty patientReposiroty;
    private MedecinReposiroty medecinReposiroty;
    private ConsultationReposiroty consultationReposiroty;
    private RendezVousReposiroty rendezVousReposiroty;

    public HospitalServiceImpl(PatientReposiroty patientReposiroty, MedecinReposiroty medecinReposiroty, ConsultationReposiroty consultationReposiroty, RendezVousReposiroty rendezVousReposiroty) {
        this.patientReposiroty = patientReposiroty;
        this.medecinReposiroty = medecinReposiroty;
        this.consultationReposiroty = consultationReposiroty;
        this.rendezVousReposiroty = rendezVousReposiroty;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientReposiroty.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinReposiroty.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousReposiroty.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationReposiroty.save(consultation);
    }
}
