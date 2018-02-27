package co.softwarebox.demos.visit;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.softwarebox.demos.configs.CachingConfig;
import co.softwarebox.demos.domain.DomainStatistics;

public interface VisitRepository extends CrudRepository<Visit, String>{

	@Cacheable(CachingConfig.DOMAINCOUNT)
	@Query(value = "SELECT new co.softwarebox.demos.domain.DomainStatistics(v.domain, count(v) as vCount) FROM Visit v GROUP BY v.domain ORDER BY vCount DESC")
	List<DomainStatistics> findDomainCount(Pageable pageable);
	
}
