/**
 * This class provides a convenient way to test shuffling methods.
 */
import java.util.List;
import java.util.ArrayList;


public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 5;
    
    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = {1,2,3,4,5};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = {1,2,3,4,5};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
            * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        //testing
        //temp1 is odd
        //temp2 is even
        int[] temp1 = new int[values.length/2];
        int[] temp2 = new int[values.length-values.length/2];
        for (int i = 0; i < temp1.length; i++){
            temp1[i] = values[i];
        }
        for (int i = 0; i < temp2.length; i++){
            temp2[i] = values[i+temp1.length];
        }   
        for (int i = 0, j = 0; i < values.length; i +=2, j++){
            values[i] = temp2[j];
        }
        for (int i = 1, j = 0; i < values.length; i +=2, j++){
            values[i] = temp1[j];
        }
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        for (int i = 0; i <= values.length-1; i++){
            int j = (int)(Math.random()) * (i);
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }
}