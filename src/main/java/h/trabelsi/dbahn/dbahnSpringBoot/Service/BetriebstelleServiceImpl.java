package h.trabelsi.dbahn.dbahnSpringBoot.Service;

import h.trabelsi.dbahn.dbahnSpringBoot.Model.Betriebstelle;
import h.trabelsi.dbahn.dbahnSpringBoot.Repository.BetriebstelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetriebstelleServiceImpl implements BetriebstelleService{

  @Autowired
  private BetriebstelleRepository eRepository;

  @Override
  public List<Betriebstelle> getBetriebstellen() {
    return eRepository.findAll();
  }

  @Override
  public Optional<Betriebstelle> getSingleBetriebstelle(String code) {
    return eRepository.findById(code);
  }
}
