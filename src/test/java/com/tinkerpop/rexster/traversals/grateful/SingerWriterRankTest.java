package com.tinkerpop.rexster.traversals.grateful;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.tinkerpop.rexster.RexsterResourceContext;
import com.tinkerpop.rexster.Tokens;
import com.tinkerpop.rexster.traversals.TraversalBaseTest;
import com.tinkerpop.rexster.traversals.TraversalException;

public class SingerWriterRankTest extends TraversalBaseTest {

	@Test
	public void evaluateApiIsJson(){
		SingerWriterRank singerWriterRank = new SingerWriterRank();
		RexsterResourceContext ctx = this.createStandardContext();
		
		try {
			JSONObject result = singerWriterRank.evaluate(ctx);
			Assert.assertNotNull(result);
			Assert.assertTrue(result.has(Tokens.API));
			Assert.assertTrue(result.optJSONObject(Tokens.API) instanceof JSONObject);
		} catch (TraversalException te) {
			te.printStackTrace();
			Assert.fail(te.getMessage());
		}
	}
}
