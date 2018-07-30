package scanword_tests.unit_tests.cross;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import scanword_client.NetClient;

import java.io.IOException;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Unit_CrossSolved_Sync {

    private NetClient objClient;
    private URL url;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        objClient = new NetClient();
        URI uri = new URI("https", "scanword-stage.smapps.net", "/rest/sync/ios", null);
        url = uri.toURL();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test_CrossSolved_Sync() throws IOException {
        Map<String, String> paramsSync = new LinkedHashMap<>();
        paramsSync.put("user_id", "3116963");
        paramsSync.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        paramsSync.put("updates", "ewogICI4NzY4YTIzZjk3NmE0MDM4ZmM1ZGEzZWQ4MDhmZDZmMCIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDIKICAgIH0sCiAgICAiX3VvdCIgOiAxNTMyNjkxOTMyCiAgfQp9");

        objClient.doRequest(url, paramsSync, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
