package ma.enset.hopital.services;

import jakarta.transaction.Transactional;
import ma.enset.hopital.entities.Consultation;
import ma.enset.hopital.entities.Medecin;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.entities.RendezVous;
import ma.enset.hopital.repositories.ConsultationRepository;
import ma.enset.hopital.repositories.MedecinRepository;
import ma.enset.hopital.repositories.PatientRepository;
import ma.enset.hopital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;


    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void saveMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
    }

    @Override
    public void saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        rendezVousRepository.save(rendezVous);
    }

    @Override
    public void saveConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }
}
