package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	protected static final int START = 1000;
	protected static final int FINISH = 2000;
	protected static final int ELEM = 100_000;
	protected static final int V = 1_000_000;
	protected static final int READ = 1000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> ar1 = new ArrayList<>();
    	for(int i = START; i<FINISH; i++) {
    		ar1.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> l1 = new LinkedList<>(ar1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	Integer tmp = null;
    	tmp = ar1.get(ar1.size() - 1);
    	ar1.set(ar1.size() - 1, ar1.get(0));
    	ar1.set(0, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
//    	for(Integer i : ar1) {
//    		System.out.println(i);
//    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	for(int i = 0; i < ELEM; i++) {
    		ar1.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Add " + ELEM + " as first in an ArrayList took " + time + "ns (" + time / V + "ms)");
    	
    	time = System.nanoTime();
    	for(int i = 0; i < ELEM; i++) {
    		l1.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Add " + ELEM + " as first in an LinkedList took " + time + "ns (" + time / V + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	time = System.nanoTime();
    	for (int i = 0; i < READ; i++ ) {
    		ar1.get(ar1.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Read " + READ + " times the middle of the ArrayList took " 
    			+ time + "ns (" + time / V + "ms)");
    	
    	time = System.nanoTime();
    	for (int i = 0; i < READ; i++ ) {
    		l1.get(l1.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Read " + READ + " times the middle of the LinkedList took " 
    			+ time + "ns (" + time / V + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> world = new TreeMap<>();
    	world.put("Africa", 1_110_635_000L);
    	world.put("Americas", 972_005_000L);
    	world.put("Antarctica", 0L);
    	world.put("Asia", 4_298_723_000L);
    	world.put("Europe", 742_452_000L);
    	world.put("Oceania", 38_304_000L);
    	
    	//il prof le popolazioni le ha messe come costanti
        /*
         * 8) Compute the population of the world
         */
    	long TotWorldPop = world.get("Africa") + world.get("Americas") + world.get("Antarctica") 
    		+ world.get("Asia") + world.get("Europe") + world.get("Oceania");
    	System.out.println("The population of the world is " + TotWorldPop);
    	
    	//il prof ha fatto un ciclo for 
    	
    }
}
