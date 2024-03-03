package ma.enset.hopital.services;

import ma.enset.hopital.entities.Consultation;
import ma.enset.hopital.entities.Medecin;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.entities.RendezVous;


public interface IHospitalService {
    void savePatient(Patient patient);
    void saveMedecin(Medecin medecin);
    void saveRendezVous(RendezVous rendezVous);
    void saveConsultation(Consultation consultation);
    Patient findPatientById(Long id);
    Medecin findMedecinById(Long id);
}
