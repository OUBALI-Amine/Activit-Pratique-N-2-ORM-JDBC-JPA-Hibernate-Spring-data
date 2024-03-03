package ma.enset.hopital;

import ma.enset.hopital.entities.*;
import ma.enset.hopital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService){
        return args -> {
            // Ajouter Patient
            Stream.of("amine","hassan","wissal","nadia")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setEmail(name+"@gmail.com");
                        hospitalService.savePatient(patient);
                    });
            // Ajouter Medecin
            Stream.of("mona","hiba","samir","karim")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@outlook.fr");
                        medecin.setSpecialite(new Random().nextBoolean()?"Dentaire":"Ophtalmologue");
                        hospitalService.saveMedecin(medecin);
                    });
            //Ajouter Rendez-vous
            Patient patient = hospitalService.findPatientById(1L);
            Medecin medecin = hospitalService.findMedecinById(7L);
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateRDV(new Date());
            rendezVous.setHeureRDV(new Time(System.currentTimeMillis()));
            rendezVous.setStatus(StatusRDV.ENCOURS);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);
            //Ajouter Consultation
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapportConsultation(new Date());
            consultation.setRendezVous(rendezVous);
            hospitalService.saveConsultation(consultation);
        };
    }
}
