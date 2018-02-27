package co.softwarebox.demos.configs;

import java.util.Date;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {
    public static final String DOMAINCOUNT = "DOMAINCOUNT";
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(DOMAINCOUNT);

        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {DOMAINCOUNT})
    @Scheduled(fixedDelay = 15000 ,  initialDelay = 500)
    public void reportCacheEvict() {
        //System.out.println("Flush Cache " + dateFormat.format(new Date()));
    }
}
