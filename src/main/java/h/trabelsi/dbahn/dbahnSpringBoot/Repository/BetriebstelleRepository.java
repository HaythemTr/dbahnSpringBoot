package h.trabelsi.dbahn.dbahnSpringBoot.Repository;

import h.trabelsi.dbahn.dbahnSpringBoot.Model.Betriebstelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetriebstelleRepository extends JpaRepository<Betriebstelle, String> {
}
