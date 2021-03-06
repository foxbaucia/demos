package co.softwarebox.demos.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>{

  public Account findByUsername(String username);

}
