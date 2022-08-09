package h.trabelsi.dbahn.dbahnSpringBoot.Service;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import h.trabelsi.dbahn.dbahnSpringBoot.Model.Betriebstelle;
import h.trabelsi.dbahn.dbahnSpringBoot.Repository.BetriebstelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
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

  @Override
  public String uploadData(MultipartFile file) throws Exception{
    List<Betriebstelle> betriebstelleList = new ArrayList<>();
    InputStream inputStream = file.getInputStream();
    CsvParserSettings setting = new CsvParserSettings();
    setting.setHeaderExtractionEnabled(true);
    CsvParser parser = new CsvParser(setting);
    List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
    parseAllRecords.forEach(record -> {
      Betriebstelle betriebstelle = new Betriebstelle();
      betriebstelle.setCode(record.getString("RL100-Code"));
      betriebstelle.setKurzName(record.getString("RL100-Kurzname"));
      betriebstelle.setLangName(record.getString("RL100-Langname"));
      betriebstelle.setTypkurz(record.getString("Typ Kurz"));
      betriebstelle.setRegionalbereich(record.getString("Regionalbereich"));
      betriebstelleList.add(betriebstelle);
    });
    eRepository.saveAll(betriebstelleList);
    return "Upload Successfull !!!";
  }
}
