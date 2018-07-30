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
    public void test_Sync_POST_CrossSolved() throws IOException {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("user_id", "3116963");
        params.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        params.put("vendor_id", "45692FEF-F609-4904-9369-E82FFD314379");
        params.put("advertising_id", "797243CA-A44D-4078-A105-CFB23CDD6F93");
        params.put("advertising_track_enabled", "1");
        params.put("vendor_key", "4d328057ae06daf4793fca3141c58c95");
        params.put("advertising_key", "03d5de31c587ad16f5fb6e833c92fc20");
        params.put("device_info", "ewogICJkZXZpY2VfaGVpZ2h0IiA6ICI2NjciLAogICJhcHBfdmVyc2lvbiIgOiAiMS43LjE2IiwKICAibGFzdF9zeW5jX2luZXRfdHlwZSIgOiAibm9fc3luY190eXBlIiwKICAiYXBwX2J1aWxkIiA6ICIyIiwKICAiYWR2ZXJ0aXNpbmdfdHJhY2tfZW5hYmxlZCIgOiAiMSIsCiAgImRldmljZV9wbGF0Zm9ybSIgOiAiaVBob25lOCwxIiwKICAiYXV0b2xvYWRfbmV3X2lzc3Vlc19vbiIgOiAiMCIsCiAgImRldmljZV9zeXN0ZW1fdmVyc2lvbiIgOiAiMTAuMi4xIiwKICAiaXNzdWVzX2xvYWRlZCIgOiAiMSIsCiAgImRldmljZV93aWR0aCIgOiAiMzc1Igp9");
        params.put("visit_id", "s25c140e4d06fa80a4awa97d844bb06e");
        params.put("request_id", "0ce5261zs1761vsja36173fad2a6260e");
        params.put("updates", "ewogICJ3NWZhNGNjNWZmMjRiMzIwMHh4eDI0NHM2YmRhNDQ0OCIgOiB7CiAgICAidWhrYiIgOiB7CiAgICAgICJrZXl3b3JkX2JvbnVzIiA6ICJbXG4gIHtcbiAgICBcImJvbnVzX25hbWVcIiA6IFwia2V5V29yZFwiLFxuICAgIFwicGFyYW1zXCIgOiB7XG4gICAgICBcImFtb3VudF92aWRlb1wiIDogMCxcbiAgICAgIFwiYW1vdW50X2tleVwiIDogMSxcbiAgICAgIFwidGltZXN0YW1wXCIgOiBcIjIwMTgtMDctMjcgMjA6MjI6NTkgKzAwMDBcIixcbiAgICAgIFwiY3Jvc3NfaWRcIiA6IDE4NjcyXG4gICAgfVxuICB9XG5dIgogICAgfSwKICAgICJfdW90IiA6IDE1MzI3MjQyOTksCiAgICAidWNtIiA6IHsKICAgICAgImMxODY3MiIgOiB7CiAgICAgICAgImgiIDogIiAgICAgIC4gLiAuICAgICAuICAuICAuICAuLi4uIC4uLi4gIC4gIC4uLi4uLiAuIC4gLi4uLi4gLi4uLi4gLiAgLi4uLiAgLi4uLiAuIC4gLi4uLiAuLi4uICAgLi4uLi4gLiAuICAuIC4uLiAuICAgLi4uIC4gLi4uLi4uLiAuIC4uLi4uIC4uLi4uICAuLi4uICAgLi4uLiAuLi4uLi4uLi4uLi4gIC4uLi4uICAgLi4uLiAgLi4uLi4uIC4uLi4gICAuLi4uIiwKICAgICAgICAiYSIgOiAiICAgICAg0LAg0YEg0LQgICAgINC9ICDRgSAg0LwgINGB0LDQvdC4INGC0YDQsNC6ICDQtSAg0YPQutGA0LXRgdGCINGFINC/INC/0L7RgtC+0L8g0YDQuNGB0LrQsCDQvSAg0LPQsNC30LAgINC80L7RgNC1INC/INGDINCx0LDRjtC9INCw0YDQuNC4ICAg0YHQsNC90YLQsCDQvyDQsCAg0L4g0LTQsNC6INC7ICAg0LvRjNC1INC9INGC0LrQvtGA0YfQvNCwINC+INCw0LLRgNCw0Lsg0LzRhtGL0YDQuCAg0LXQvdC+0LsgICDRgNC10YPRgiDQv9Cw0YHRgtC+0YDQvNC10L3QuNGB0LogINGC0ZHRgNC60LAgICDQutC40YHQsCAg0L7QutGC0LDQstCwINC60LDQsNGBICAg0LDQutCw0L0iCiAgICAgIH0KICAgIH0sCiAgICAidXVzIiA6IHsKICAgICAgInRvbGgiIDogMSwKICAgICAgImhjbyIgOiAxMjksCiAgICAgICJ0YyIgOiA5LAogICAgICAiaGx1IiA6IDEKICAgIH0KICB9LAogICJ3NWZhNGNjNWZmMjRiMzIwMHh4eDI0NDk2YmRhNDQ0OCIgOiB7CiAgICAidWhrYiIgOiB7CiAgICAgICJrZXl3b3JkX2JvbnVzIiA6ICJbXG4gIHtcbiAgICBcImJvbnVzX25hbWVcIiA6IFwia2V5V29yZFwiLFxuICAgIFwicGFyYW1zXCIgOiB7XG4gICAgICBcImFtb3VudF92aWRlb1wiIDogMCxcbiAgICAgIFwiYW1vdW50X2tleVwiIDogMSxcbiAgICAgIFwidGltZXN0YW1wXCIgOiBcIjIwMTgtMDctMjcgMjA6MjI6NTkgKzAwMDBcIixcbiAgICAgIFwiY3Jvc3NfaWRcIiA6IDE4NjcyXG4gICAgfVxuICB9XG5dIgogICAgfSwKICAgICJfdW90IiA6IDE1MzI3MjQyOTksCiAgICAidWNtIiA6IHsKICAgICAgImMxODY3MiIgOiB7CiAgICAgICAgImgiIDogIiAgICAgIC4gLiAuICAgICAuICAuICAuICAuLi4uIC4uLi4gIC4gIC4uLi4uLiAuIC4gLi4uLi4gLi4uLi4gLiAgLi4uLiAgLi4uLiAuIC4gLi4uLiAuLi4uICAgLi4uLi4gLiAuICAuIC4uLiAuICAgLi4uIC4gLi4uLi4uLiAuIC4uLi4uIC4uLi4uICAuLi4uICAgLi4uLiAuLi4uLi4uLi4uLi4gIC4uLi4uICAgLi4uLiAgLi4uLi4uIC4uLi4gICAuLi4uIiwKICAgICAgICAiYSIgOiAiICAgICAg0LAg0YEg0LQgICAgINC9ICDRgSAg0LwgINGB0LDQvdC4INGC0YDQsNC6ICDQtSAg0YPQutGA0LXRgdGCINGFINC/INC/0L7RgtC+0L8g0YDQuNGB0LrQsCDQvSAg0LPQsNC30LAgINC80L7RgNC1INC/INGDINCx0LDRjtC9INCw0YDQuNC4ICAg0YHQsNC90YLQsCDQvyDQsCAg0L4g0LTQsNC6INC7ICAg0LvRjNC1INC9INGC0LrQvtGA0YfQvNCwINC+INCw0LLRgNCw0Lsg0LzRhtGL0YDQuCAg0LXQvdC+0LsgICDRgNC10YPRgiDQv9Cw0YHRgtC+0YDQvNC10L3QuNGB0LogINGC0ZHRgNC60LAgICDQutC40YHQsCAg0L7QutGC0LDQstCwINC60LDQsNGBICAg0LDQutCw0L0iCiAgICAgIH0KICAgIH0sCiAgICAidXVzIiA6IHsKICAgICAgInRvbGgiIDogMSwKICAgICAgImhjbyIgOiAxMjksCiAgICAgICJ0YyIgOiA5LAogICAgICAiaGx1IiA6IDEKICAgIH0KICB9Cn0=");

        objClient.doRequest(url, params, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }

    @Test
    public void test_Sync_POST_CrossSolved_Double() throws IOException {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("user_id", "3116963");
        params.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        params.put("vendor_id", "45692FEF-F609-4904-9369-E82FFD314379");
        params.put("advertising_id", "797243CA-A44D-4078-A105-CFB23CDD6F93");
        params.put("advertising_track_enabled", "1");
        params.put("vendor_key", "4d328057ae06daf4793fca3141c58c95");
        params.put("advertising_key", "03d5de31c587ad16f5fb6e833c92fc20");
        params.put("device_info", "ewogICJkZXZpY2VfaGVpZ2h0IiA6ICI2NjciLAogICJhcHBfdmVyc2lvbiIgOiAiMS43LjE2IiwKICAibGFzdF9zeW5jX2luZXRfdHlwZSIgOiAibm9fc3luY190eXBlIiwKICAiYXBwX2J1aWxkIiA6ICIyIiwKICAiYWR2ZXJ0aXNpbmdfdHJhY2tfZW5hYmxlZCIgOiAiMSIsCiAgImRldmljZV9wbGF0Zm9ybSIgOiAiaVBob25lOCwxIiwKICAiYXV0b2xvYWRfbmV3X2lzc3Vlc19vbiIgOiAiMCIsCiAgImRldmljZV9zeXN0ZW1fdmVyc2lvbiIgOiAiMTAuMi4xIiwKICAiaXNzdWVzX2xvYWRlZCIgOiAiMSIsCiAgImRldmljZV93aWR0aCIgOiAiMzc1Igp9");
        params.put("visit_id", "375ww4444d06fewba4aca97d844bb06e");
        params.put("request_id", "1cess618ss263csja36173faffa6260e");
        params.put("updates", "ewogICI4NWMxNGNjNTU4YTRiMzJmMDE2NzI0NDk2YmRhMzM1OCIgOiB7CiAgICAidWhrYiIgOiB7CiAgICAgICJrZXl3b3JkX2JvbnVzIiA6ICJbXG4gIHtcbiAgICBcImJvbnVzX25hbWVcIiA6IFwia2V5V29yZFwiLFxuICAgIFwicGFyYW1zXCIgOiB7XG4gICAgICBcImFtb3VudF92aWRlb1wiIDogMCxcbiAgICAgIFwiYW1vdW50X2tleVwiIDogMSxcbiAgICAgIFwidGltZXN0YW1wXCIgOiBcIjIwMTgtMDctMjcgMTM6MjI6NTkgKzAwMDBcIixcbiAgICAgIFwiY3Jvc3NfaWRcIiA6IDE4NjY5XG4gICAgfVxuICB9XG5dIgogICAgfSwKICAgICJfdW90IiA6IDE1MzI2OTc3NzksCiAgICAidWNtIiA6IHsKICAgICAgImMxODY3MSIgOiB7CiAgICAgICAgImgiIDogIiAgICAgIC4gLiAuICAgICAuICAuICAuICAuLi4uIC4uLi4gIC4gIC4uLi4uLiAuIC4gLi4uLi4gLi4uLi4gLiAgLi4uLiAgLi4uLiAuIC4gLi4uLiAuLi4uICAgLi4uLi4gLiAuICAuIC4uLiAuICAgLi4uIC4gLi4uLi4uLiAuIC4uLi4uIC4uLi4uICAuLi4uICAgLi4uLiAuLi4uLi4uLi4uLi4gIC4uLi4uICAgLi4uLiAgLi4uLi4uIC4uLi4gICAuLi4uIiwKICAgICAgICAiYSIgOiAiICAgICAg0YEg0YEg0LQgICAgINC9ICDRgSAg0LwgINGB0LDQvdC4INGC0YDQsNC6ICDQtSAg0YPQutGA0LXRgdGCINGFINC/INC/0L7RgtC+0L8g0YDQuNGB0LrQsCDQvSAg0LPQsNC30LAgINC80L7RgNC1INC/INGDINCx0LDRjtC9INCw0YDQuNC4ICAg0YHQsNC90YLQsCDQvyDQsCAg0L4g0LTQsNC6INC7ICAg0LvRjNC1INC9INGC0LrQvtGA0YfQvNCwINC+INCw0LLRgNCw0Lsg0LzRhtGL0YDQuCAg0LXQvdC+0LsgICDRgNC10YPRgiDQv9Cw0YHRgtC+0YDQvNC10L3QuNGB0LogINGC0ZHRgNC60LAgICDQutC40YHQsCAg0L7QutGC0LDQstCwINC60LDQsNGBICAg0LDQutCw0L0iCiAgICAgIH0KICAgIH0sCiAgICAidXVzIiA6IHsKICAgICAgInRvbGgiIDogMSwKICAgICAgImhjbyIgOiAxMjksCiAgICAgICJ0YyIgOiA5LAogICAgICAiaGx1IiA6IDEKICAgIH0KICB9Cn0=");

        Map<String, String> params_2 = new LinkedHashMap<>();
        params_2.put("user_id", "3116963");
        params_2.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        params_2.put("vendor_id", "45692FEF-F609-4904-9369-E82FFD314379");
        params_2.put("advertising_id", "797243CA-A44D-4078-A105-CFB23CDD6F93");
        params_2.put("advertising_track_enabled", "1");
        params_2.put("vendor_key", "4d328057ae06daf4793fca3141c58c95");
        params_2.put("advertising_key", "03d5de31c587ad16f5fb6e833c92fc20");
        params_2.put("device_info", "ewogICJkZXZpY2VfaGVpZ2h0IiA6ICI2NjciLAogICJhcHBfdmVyc2lvbiIgOiAiMS43LjE2IiwKICAibGFzdF9zeW5jX2luZXRfdHlwZSIgOiAibm9fc3luY190eXBlIiwKICAiYXBwX2J1aWxkIiA6ICIyIiwKICAiYWR2ZXJ0aXNpbmdfdHJhY2tfZW5hYmxlZCIgOiAiMSIsCiAgImRldmljZV9wbGF0Zm9ybSIgOiAiaVBob25lOCwxIiwKICAiYXV0b2xvYWRfbmV3X2lzc3Vlc19vbiIgOiAiMCIsCiAgImRldmljZV9zeXN0ZW1fdmVyc2lvbiIgOiAiMTAuMi4xIiwKICAiaXNzdWVzX2xvYWRlZCIgOiAiMSIsCiAgImRldmljZV93aWR0aCIgOiAiMzc1Igp9");
        params_2.put("visit_id", "125c14444d06fewba4aca97dfs4bb06e");
        params_2.put("request_id", "1ce52618s1763csja36173faffa6260e");
        params_2.put("updates", "ewogICI4NWMxNGNjNWZmMjRiMzJmMDE2NzI0NDk2YmRhNDQ0OCIgOiB7CiAgICAidWhrYiIgOiB7CiAgICAgICJrZXl3b3JkX2JvbnVzIiA6ICJbXG4gIHtcbiAgICBcImJvbnVzX25hbWVcIiA6IFwia2V5V29yZFwiLFxuICAgIFwicGFyYW1zXCIgOiB7XG4gICAgICBcImFtb3VudF92aWRlb1wiIDogMCxcbiAgICAgIFwiYW1vdW50X2tleVwiIDogMSxcbiAgICAgIFwidGltZXN0YW1wXCIgOiBcIjIwMTgtMDctMjcgMTM6MjI6NTkgKzAwMDBcIixcbiAgICAgIFwiY3Jvc3NfaWRcIiA6IDE4NjY5XG4gICAgfVxuICB9XG5dIgogICAgfSwKICAgICJfdW90IiA6IDE1MzI2OTc3NzksCiAgICAidWNtIiA6IHsKICAgICAgImMxODY3MSIgOiB7CiAgICAgICAgImgiIDogIiAgICAgIC4gLiAuICAgICAuICAuICAuICAuLi4uIC4uLi4gIC4gIC4uLi4uLiAuIC4gLi4uLi4gLi4uLi4gLiAgLi4uLiAgLi4uLiAuIC4gLi4uLiAuLi4uICAgLi4uLi4gLiAuICAuIC4uLiAuICAgLi4uIC4gLi4uLi4uLiAuIC4uLi4uIC4uLi4uICAuLi4uICAgLi4uLiAuLi4uLi4uLi4uLi4gIC4uLi4uICAgLi4uLiAgLi4uLi4uIC4uLi4gICAuLi4uIiwKICAgICAgICAiYSIgOiAiICAgICAg0YEg0YEg0LQgICAgINC9ICDRgSAg0LwgINGB0LDQvdC4INGC0YDQsNC6ICDQtSAg0YPQutGA0LXRgdGCINGFINC/INC/0L7RgtC+0L8g0YDQuNGB0LrQsCDQvSAg0LPQsNC30LAgINC80L7RgNC1INC/INGDINCx0LDRjtC9INCw0YDQuNC4ICAg0YHQsNC90YLQsCDQvyDQsCAg0L4g0LTQsNC6INC7ICAg0LvRjNC1INC9INGC0LrQvtGA0YfQvNCwINC+INCw0LLRgNCw0Lsg0LzRhtGL0YDQuCAg0LXQvdC+0LsgICDRgNC10YPRgiDQv9Cw0YHRgtC+0YDQvNC10L3QuNGB0LogINGC0ZHRgNC60LAgICDQutC40YHQsCAg0L7QutGC0LDQstCwINC60LDQsNGBICAg0LDQutCw0L0iCiAgICAgIH0KICAgIH0sCiAgICAidXVzIiA6IHsKICAgICAgInRvbGgiIDogMSwKICAgICAgImhjbyIgOiAxMjksCiAgICAgICJ0YyIgOiA5LAogICAgICAiaGx1IiA6IDEKICAgIH0KICB9Cn0=");

        objClient.doRequest(url, params, "POST");
        objClient.doRequest(url, params_2, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}