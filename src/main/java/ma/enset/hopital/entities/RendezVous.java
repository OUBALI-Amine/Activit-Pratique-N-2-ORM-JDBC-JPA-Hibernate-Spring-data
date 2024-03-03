package ma.enset.hopital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @Temporal(TemporalType.TIME)
    private Date heureRDV;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Consultation consultation;
}
