package IesPerezMinik.Gestor.de.Correos.Api;

import com.microsoft.aad.msal4j.ITokenCacheAccessAspect;
import com.microsoft.aad.msal4j.ITokenCacheAccessContext;
import com.microsoft.aad.msal4j.PublicClientApplication;

public class TokenPersistence implements ITokenCacheAccessAspect {
		
	String data;

		TokenPersistence(String data) {
		        this.data = data;
		}

		@Override
		public void beforeCacheAccess(ITokenCacheAccessContext iTokenCacheAccessContext) {
		        iTokenCacheAccessContext.tokenCache().deserialize(data);
		}

		@Override
		public void afterCacheAccess(ITokenCacheAccessContext iTokenCacheAccessContext) {
		        data = iTokenCacheAccessContext.tokenCache().serialize();
		}
	
		public void meterToken() {
			// Loads cache from file
			String dataToInitCache = readResource(this.getClass(), "/cache_data/serialized_cache.json");

			ITokenCacheAccessAspect persistenceAspect = new TokenPersistence(dataToInitCache);

			// By setting *TokenPersistence* on the PublicClientApplication, MSAL will call *beforeCacheAccess()* before accessing the cache and *afterCacheAccess()* after accessing the cache. 
			PublicClientApplication app = 
			PublicClientApplication.builder("a05b32ec-25e0-44b0-ac61-986f8a08746d").setTokenCacheAccessAspect(persistenceAspect).build();
		}
		
}
