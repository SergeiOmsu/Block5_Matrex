import java.util.Comparator;

public class DeterminantComparator implements Comparator<IMatrix>
{

    @Override
    public int compare(IMatrix o1, IMatrix o2) {
        o2.getDeterminant();
        double i = o1.getActualDeterminant();
        o2.getDeterminant();
        return Double.compare(i, o2.getActualDeterminant());
    }
}
