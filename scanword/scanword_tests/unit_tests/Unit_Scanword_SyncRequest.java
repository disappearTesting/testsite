package scanword_tests.unit_tests;

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

public class Unit_Scanword_SyncRequest {

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
        paramsSync.put("vendor_id", "45692FEF-F609-4904-9369-E82FFD314379");
        paramsSync.put("advertising_id", "797243CA-A44D-4078-A105-CFB23CDD6F93");
        paramsSync.put("advertising_track_enabled", "1");
        paramsSync.put("vendor_key", "4d328057ae06daf4793fca3141c58c95");
        paramsSync.put("advertising_key", "03d5de31c587ad16f5fb6e833c92fc20");
        paramsSync.put("device_info", "ewogICJkZXZpY2VfaGVpZ2h0IiA6ICI2NjciLAogICJhcHBfdmVyc2lvbiIgOiAiMS43LjE2IiwKICAibGFzdF9zeW5jX2luZXRfdHlwZSIgOiAibm9fc3luY190eXBlIiwKICAiYXBwX2J1aWxkIiA6ICIyIiwKICAiYWR2ZXJ0aXNpbmdfdHJhY2tfZW5hYmxlZCIgOiAiMSIsCiAgImRldmljZV9wbGF0Zm9ybSIgOiAiaVBob25lOCwxIiwKICAiYXV0b2xvYWRfbmV3X2lzc3Vlc19vbiIgOiAiMCIsCiAgImRldmljZV9zeXN0ZW1fdmVyc2lvbiIgOiAiMTAuMi4xIiwKICAiaXNzdWVzX2xvYWRlZCIgOiAiMSIsCiAgImRldmljZV93aWR0aCIgOiAiMzc1Igp9");
        paramsSync.put("visit_id", "375c140e4d06ca8b16aca97d844bb06e");
        paramsSync.put("request_id", "2600e7cf50354b34e411ca4fdfdbd84e");
        paramsSync.put("updates", "ewogICI4NzY4YTIzZjk3NmE0MDM4ZmM1ZGEzZWQ4MDhmZDZmMCIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDIKICAgIH0sCiAgICAiX3VvdCIgOiAxNTMyNjkxOTMyCiAgfQp9");

        objClient.doRequest(url, paramsSync, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }

    @Test
    public void test_SudokuSolved_SuLiDa_Info() {

    }
}
