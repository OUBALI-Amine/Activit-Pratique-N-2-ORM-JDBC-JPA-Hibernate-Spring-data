package ma.enset.hopital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient extends Personne {
    @OneToMany(mappedBy = "patient" ,fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
