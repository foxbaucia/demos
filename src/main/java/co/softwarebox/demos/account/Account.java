package co.softwarebox.demos.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {
  
  @Id
  @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
  private Long id;

  private String username;
  
  private String password;
  
  public Account(){}
  
  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }

}
