package co.softwarebox.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.validator.routines.UrlValidator;

public class Utils {

	/**
	 * Validate if an string is null or empty
	 * @param arg
	 * @return true for empty or null string.
	 */
	public static boolean isBlank(String arg) {
		if (arg == null) {
			return true;
		}
		if (arg.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	

	/**
	 * Validate if an string is neither null nor empty
	 * @param arg
	 * @return true for NOT empty or null string.
	 */
	public static boolean isNotBlank(String arg) {
		return !isBlank(arg);
	}

	/**
	 * Check if a URL is valid 
	 * 
	 * @param url
	 * @param schemes
	 * @return true if is a valid URL for the given schemas, false if is not a valid url. 
	 */
    public static boolean isURL(final String url, final String[] schemes) {

        if (isBlank(url)) {
            return false;
        }

        final UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(url.toLowerCase());
    }

    /**
     * Check if a URL is valid only for http or https schemas
     * @param url
	 * @return true if is a valid URL for the http or https schemas, false if is not a valid url. 
     */
    public static boolean isURL(final String url) {

        final String[] schemes = {
                "http", "https"
        };
        return isURL(url, schemes);
    }

    /**
     * 
     * Returns only the domain of a given URL. 
     * i.e.: https://accounts.softwarebox.co/mypage/index.html?foo=bar will return softwarebox.co
     * 
     * @param url
     * 
     * @return String with only the domain.
     * 
     * @throws URISyntaxException
     * 
     */
    public static String getDomainName(String url) throws URISyntaxException {

    		URI uri = new URI(url);
        String domain = uri.getHost();
        if (Utils.isBlank(domain)) {
        		throw new IllegalArgumentException("The url '" + url + "' is not a valid url");
        }
        
        // Split by dots
        String[] split = domain.split("\\.");
        int splitLength = split.length;
		if (splitLength <= 2) {
        		// this is all the domain that we need
        		return domain;
        }
        
        // we only want the last 2
        domain = split[splitLength-2] + "." + split[splitLength-1];
        return domain;

    }

}
