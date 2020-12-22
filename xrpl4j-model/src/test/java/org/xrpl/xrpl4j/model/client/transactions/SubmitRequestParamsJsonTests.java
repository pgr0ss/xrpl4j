package org.xrpl.xrpl4j.model.client.transactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.Test;
import org.xrpl.xrpl4j.model.AbstractJsonTest;

public class SubmitRequestParamsJsonTests extends AbstractJsonTest {

  @Test
  public void testJson() throws JsonProcessingException, JSONException {

    SubmitRequestParams params = SubmitRequestParams.of(
        "1200002280000000240000000361D4838D7EA4C6800000000000000000000000000055534400000000004B4E9C06F24296074F7BC48" +
            "F92A97916C6DC5EA968400000000000000A732103AB40A0490F9B7ED8DF29D246BF2D6269820A0EE7742ACDD457BEA7C7D0931E" +
            "DB74473045022100D184EB4AE5956FF600E7536EE459345C7BBCF097A84CC61A93B9AF7197EDB98702201CEA8009B7BEEBAA2AA" +
            "CC0359B41C427C1C5B550A4CA4B80CF2174AF2D6D5DCE81144B4E9C06F24296074F7BC48F92A97916C6DC5EA983143E9D4A2B8A" +
            "A0780F682D136F7A56D6724EF53754"
    );

    String json = "{\n" +
        "            \"tx_blob\": \"1200002280000000240000000361D4838D7EA4C68000000000000000000000000000555344000000" +
        "00004B4E9C06F24296074F7BC48F92A97916C6DC5EA968400000000000000A732103AB40A0490F9B7ED8DF29D246BF2D6269820A0EE" +
        "7742ACDD457BEA7C7D0931EDB74473045022100D184EB4AE5956FF600E7536EE459345C7BBCF097A84CC61A93B9AF7197EDB9870220" +
        "1CEA8009B7BEEBAA2AACC0359B41C427C1C5B550A4CA4B80CF2174AF2D6D5DCE81144B4E9C06F24296074F7BC48F92A97916C6DC5EA" +
        "983143E9D4A2B8AA0780F682D136F7A56D6724EF53754\"\n" +
        "        }";

    assertCanSerializeAndDeserialize(params, json);
  }
}