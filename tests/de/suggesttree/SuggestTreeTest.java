package de.suggesttree;

import java.util.Comparator;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.suggesttree.SuggestTree.Node;
import de.suggesttree.SuggestTree.Pair;

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
	public void testNormal() {
		HashMap<Pair<Integer>, Integer> suggestions = new HashMap<Pair<Integer>, Integer>();
		suggestions.put(new Pair<Integer>("tests", 2), 2);
		suggestions.put(new Pair<Integer>("test", 1), 1);
		suggestions.put(new Pair<Integer>("tes", 4), 4);
		suggestions.put(new Pair<Integer>("te", 3), 3);
		suggestions.put(new Pair<Integer>("t", 5), 5);
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer e1, Integer e2) {
				return Integer.compare(e1, e2);
			}
		};
		this.s.build(suggestions, c, 5);
		Node<Integer> result = this.s.getBestSuggestions("te");
		System.out.println("te:");
		for (int i = 0; i < result.listLength(); i++) {
			System.out.println(result.getSuggestion(i).getString() + " "
					+ result.getSuggestion(i).getScore());
		}
	}
}
