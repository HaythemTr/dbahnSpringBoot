package h.trabelsi.dbahn.dbahnSpringBoot.Service;

import h.trabelsi.dbahn.dbahnSpringBoot.Model.Betriebstelle;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BetriebstelleService {
  List<Betriebstelle> getBetriebstellen();
  Optional<Betriebstelle> getSingleBetriebstelle(String code);
  String uploadData (MultipartFile file) throws Exception;
}
