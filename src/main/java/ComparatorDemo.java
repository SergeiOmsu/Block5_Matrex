import java.util.Arrays;

    public class ComparatorDemo {
        public static void sortProducts(IMatrix... matrix) {
            Arrays.sort(matrix, new DeterminantComparator());
        }
    }

