import static org.junit.Assert.*;
import model.Bullhorn;

import org.junit.Test;


public class DatabaseTest {

	@Test
	public void testInsert() {
		Bullhorn post = new Bullhorn();
		post.setPost("dsaghfhjdg");
		Database.insert(post);
	}

}
