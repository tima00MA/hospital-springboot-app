package ma.fs.hospital.web;

import ma.fs.hospital.entities.Patient;
import ma.fs.hospital.repositories.PatientReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientReposiroty patientReposiroty;
    @GetMapping("/patients")
    public List<Patient> patientList() {
        return patientReposiroty.findAll();
    }
}
