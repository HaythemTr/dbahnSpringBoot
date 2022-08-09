package h.trabelsi.dbahn.dbahnSpringBoot.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name="betriebsstellen1")
//@Table(name = "betrieb")
public class Betriebstelle {
  @Id
  @Column(name="code")
  private String code;
  @Column(name="langname")
  private String langName;
  @Column(name="kurzname")
  private String kurzName;
  @Column(name="typkurz")
  private String typkurz;
  @Column(name="regionalbereich")
  private String regionalbereich;
}
