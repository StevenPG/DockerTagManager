package com.stevengantz.docker.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImageTagsTest {

	public ImageTags tagobj = new ImageTags();
	
	@Before
	public void setUp() throws Exception {
		tagobj.setName("ubuntu");
		List<String> tags = new ArrayList<>();
		tags.add("latest");
		tags.add("14.04");
		tags.add("16.04");
		tags.add("15.10");
		tagobj.setTags(tags);
	}

	@After
	public void tearDown() throws Exception {
		tagobj = null;
	}

	@Test
	public void testImageTags() {
		ImageTags imgtags = new ImageTags();
		assertNotNull(imgtags);
	}

	@Test
	public void testGetName() {
		ImageTags imgtags = new ImageTags();
		imgtags.setName("ubuntu");
		assertEquals(tagobj.getName(), imgtags.getName());
	}

	@Test
	public void testSetName() {
		ImageTags imgtags = new ImageTags();
		imgtags.setName("ubuntu");
		assertEquals(tagobj.getName(), imgtags.getName());
	}

	@Test
	public void testGetTags() {
		List<String> tags = new ArrayList<>();
		tags.add("latest");
		tags.add("14.04");
		tags.add("16.04");
		tags.add("15.10");
		
		ImageTags imgtags = new ImageTags();
		imgtags.setTags(tags);
		
		for(int i = 0; i < tags.size(); i++) {
			assertEquals(tags.get(i), imgtags.getTags().get(i));
		}
	}

	@Test
	public void testSetTags() {
		List<String> tags = new ArrayList<>();
		tags.add("latest");
		tags.add("14.04");
		tags.add("16.04");
		tags.add("15.10");
		
		ImageTags imgtags = new ImageTags();
		imgtags.setTags(tags);
		
		for(int i = 0; i < tags.size(); i++) {
			assertEquals(tags.get(i), imgtags.getTags().get(i));
		}
	}

	@Test
	public void testToString() {
		String expected = "ImageTags {name=ubuntu, tags=latest, 14.04, 16.04, 15.10, }";
		assertEquals(expected, tagobj.toString());

	}

}
