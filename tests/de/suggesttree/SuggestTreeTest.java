package de.suggesttree;

import java.util.Comparator;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.suggesttree.SuggestTree.Node;

public class SuggestTreeTest {
	SuggestTree<Integer> s;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.s = new SuggestTree<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		HashMap<String, Integer> suggestions = new HashMap<String, Integer>();
		suggestions.put("tests", 2);
		suggestions.put("test", 1);
		suggestions.put("tes", 4);
		suggestions.put("te", 3);
		suggestions.put("t", 5);
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				return Integer.compare(e1, e2);
			}
		};
		this.s.build(suggestions, comparator, 5);

		Node<Integer> result = this.s.getBestSuggestions("te");
		System.out.println("te:");
		for (int i = 0; i < result.listLength(); i++) {
			System.out.println(result.getSuggestion(i).getString() + " "
					+ result.getSuggestion(i).getScore());
		}

	}
}
