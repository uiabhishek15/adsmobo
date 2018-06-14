package com.banana.spytutors.web.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

/**
 * 
 * @author ANKEM
 *
 */

@ApplicationScoped
public class CacheConfig {
	
	private static final EmbeddedCacheManager CACHE_MANAGER;
	
	@Produces
	@Default
	public static Configuration defaultEmbeddedCacheConfiguration(){
		return new ConfigurationBuilder()
				  .clustering()
				  .cacheMode(CacheMode.DIST_SYNC)
				  .sync()
				  .l1().lifespan(25000L)
				  .hash().numOwners(3)
				  .build();
	}
	
	@Produces
	@Default
	@ApplicationScoped
	public static EmbeddedCacheManager defaultEmbeddedCacheMananger(){
		return new DefaultCacheManager(defaultEmbeddedCacheConfiguration());
	}
	
	static {	     
	         CACHE_MANAGER = defaultEmbeddedCacheMananger();	      
	}
	
	/**
	    * Retrieves the default cache.
	    * @param <K> type used as keys in this cache
	    * @param <V> type used as values in this cache
	    * @return a cache
	    */
	   public static <K, V> Cache<K, V> getCache() {
	      return CACHE_MANAGER.getCache();
	   }
	 
	   /**
	    * Retrieves a named cache.
	    * @param cacheName name of cache to retrieve
	    * @param <K> type used as keys in this cache
	    * @param <V> type used as values in this cache
	    * @return a cache
	    */
	   public static <K, V> Cache<K, V> getCache(String cacheName) {
	      if (cacheName == null) throw new NullPointerException("Cache name cannot be null!");
	      return CACHE_MANAGER.getCache(cacheName);
	   }
	   
	   /**
	    * Retrieves the embedded cache manager.
	    * @return a cache manager
	    */
	   public static EmbeddedCacheManager getCacheContainer() {
	      return CACHE_MANAGER;
	   }
	
}
