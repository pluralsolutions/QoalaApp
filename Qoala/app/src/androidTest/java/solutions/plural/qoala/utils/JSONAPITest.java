package solutions.plural.qoala.utils;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * Created by gabri on 18/09/2016.
 */
public class JSONAPITest {

    @Test
    public void testGetJSON() throws Exception {
        JSONObject retorno = JSONAPI2.GetJSON("http://ws.qoala.com.br/", new JSONStringer());
        assertTrue(retorno.has("version"));
    }

    @Test
    public void testPostJSON() throws Exception {
        JSONObject retorno = JSONAPI2.PostJSON("http://ws.qoala.com.br/", new JSONStringer());
        assertTrue(retorno.has("version"));
    }
}