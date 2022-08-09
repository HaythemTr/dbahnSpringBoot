package h.trabelsi.dbahn.dbahnSpringBoot.Controller;

import h.trabelsi.dbahn.dbahnSpringBoot.Model.Betriebstelle;
import h.trabelsi.dbahn.dbahnSpringBoot.Service.BetriebstelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BetriebstelleController {
  @Autowired
  private BetriebstelleService eService;

  @GetMapping("/betriebstellen")
  public List<Betriebstelle> getBetriebstellen() {
    return eService.getBetriebstellen();
  }

  @GetMapping("/betriebstellen/{code}")
  public Optional<Betriebstelle> getSingleBetriebstelle(@PathVariable("code") String code) {
    return eService.getSingleBetriebstelle(code);
  }
}
