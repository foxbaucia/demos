package co.softwarebox.utils;

import java.net.URISyntaxException;

import org.junit.Test;

import junit.framework.TestCase;

public class UtilsTest extends TestCase {


    @Test
    public void testIsBlankAndIsNotBlank() {

        assertTrue(Utils.isBlank(null));
        assertTrue(Utils.isBlank(""));
        assertTrue(Utils.isBlank("     "));

        assertFalse(Utils.isBlank("  foobar   "));

        assertFalse(Utils.isNotBlank(null));
        assertFalse(Utils.isNotBlank(""));
        assertFalse(Utils.isNotBlank("     "));

        assertTrue(Utils.isNotBlank("  foobar   "));
    }

    
    @Test
    public void testIsUrl() {

    
        // Default schemas are HTTP and HTTPS.
        assertTrue(Utils.isURL("http://www.softwarebox.co"));
        assertTrue(Utils.isURL("https://www.softwarebox.co"));
        assertTrue(Utils.isURL("HTTP://www.softwarebox.co"));
        assertTrue(Utils.isURL("HTTPS://www.softwarebox.co"));
        assertTrue(Utils.isURL("http://softwarebox.co"));
        assertTrue(Utils.isURL("https://softwarebox.co"));

        assertFalse(Utils.isURL("ftp://www.softwarebox.co"));
        assertFalse(Utils.isURL("ftps://www.softwarebox.co"));
        assertFalse(Utils.isURL("www.softwarebox.co"));

        // Defining schemas.
        final String[] schemas = {
                "http", "https", "ftp", "ftps"
        };
        assertTrue(Utils.isURL("http://www.softwarebox.co", schemas));
        assertTrue(Utils.isURL("https://www.softwarebox.co", schemas));
        assertTrue(Utils.isURL("HTTP://www.softwarebox.co", schemas));
        assertTrue(Utils.isURL("HTTPS://www.softwarebox.co", schemas));
        assertTrue(Utils.isURL("http://softwarebox.co", schemas));
        assertTrue(Utils.isURL("https://softwarebox.co", schemas));
        assertTrue(Utils.isURL("ftp://www.softwarebox.co", schemas));
        assertTrue(Utils.isURL("ftps://www.softwarebox.co", schemas));

        assertFalse(Utils.isURL("www.softwarebox.co", schemas));
    }
    
    
    @Test
    public void testDomainName() throws URISyntaxException {

		assertEquals("softwarebox.co", Utils.getDomainName("http://www.softwarebox.co"));
		assertEquals("softwarebox.co", Utils.getDomainName("http://accounts.softwarebox.co"));
		assertEquals("softwarebox.co", Utils.getDomainName("ftp://softwarebox.co"));
		assertEquals("softwarebox.co", Utils.getDomainName("https://accounts.softwarebox.co/page/index.html"));
		assertEquals("softwarebox.co", Utils.getDomainName("https://admin.softwarebox.co/foo?parameter=one"));
    
    }

    
    
}
