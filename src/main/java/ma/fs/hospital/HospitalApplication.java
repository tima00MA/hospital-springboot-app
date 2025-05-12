package ma.fs.hospital;

import ma.fs.hospital.entities.*;
import ma.fs.hospital.repositories.ConsultationReposiroty;
import ma.fs.hospital.repositories.MedecinReposiroty;
import ma.fs.hospital.repositories.PatientReposiroty;
import ma.fs.hospital.repositories.RendezVousReposiroty;
import ma.fs.hospital.service.HospitalServiceImpl;
import ma.fs.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

    @Bean // cette notation veux dire que la methode sera execute au demarage + va returne un objet(devient un composent spring)

	CommandLineRunner start(IHospitalService hospitalService,
							PatientReposiroty patientReposiroty,
							RendezVousReposiroty  rendezVousReposiroty,
							MedecinReposiroty medecinReposiroty) {
		return args -> {
			Stream.of("Fatima", "Med", "Zineb")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDeteNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});

			Stream.of("Aziz", "Dania", "Khadija")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
						hospitalService.saveMedecin(medecin);

					});
		Patient patient =patientReposiroty.findById(1L).orElse(null);
        Patient patient1=patientReposiroty.findByNom("Fatima");
		Medecin medecin=medecinReposiroty.findByNom("Aziz");

		RendezVous rendezVous=new RendezVous();
		rendezVous.setDate(new Date());
		rendezVous.setStatus(StatusRDV.PENDING);
		rendezVous.setMedecin(medecin);
		rendezVous.setPatient(patient);
		RendezVous saveRDV= hospitalService.saveRendezVous(rendezVous);
		System.out.println(saveRDV.getId());

		RendezVous rendezVous1=rendezVousReposiroty.findAll().get(0);
		Consultation consultation=new Consultation();
		consultation.setDateConsultation(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapport("Rapport de la Consultation...........");
		hospitalService.saveConsultation(consultation);
		};

	}
}
