import org.junit.Test;
import static org.junit.Assert.*;

public class TestMatrix
{
    @Test
    public void TestDeterminant()
    {
        Matrix matrix1 = new Matrix(3);
        matrix1.setelem(0, 0, 1);
        matrix1.setelem(0, 1, 2);
        matrix1.setelem(0, 2, 3);
        matrix1.setelem(1, 0, 0);
        matrix1.setelem(1, 1, 3);
        matrix1.setelem(1, 2, 0);
        matrix1.setelem(2, 0, 1);
        matrix1.setelem(2, 1, 2);
        matrix1.setelem(2, 2, 4);
        matrix1.getDeterminant();
        assertEquals(Double.compare(matrix1.getActualDeterminant(), 3), 0);
    }

    @Test
    public void TestDeterminant1()
    {
        double[] a = new double[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        DiagMatrix matrix = new DiagMatrix(a);
        matrix.getDeterminant();
        assertEquals(Double.compare(matrix.getActualDeterminant(), 6), 0);
    }
    @Test
    public void TestDeterminant2()
    {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setelem(0, 0, 1);
        matrix.setelem(0, 1, 2);
        matrix.setelem(0, 2, 3);
        matrix.setelem(1, 1, 4);
        matrix.setelem(1, 2, 5);
        matrix.setelem(2, 2, 6);
        System.out.println(matrix.getElemByIndex(1,2));
        matrix.getDeterminant();
        assertEquals(Double.compare(matrix.getActualDeterminant(), 24), 0);
    }
    @Test
    public void TestDeterminant3()
    {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setelem(0, 0, 1);
        matrix.setelem(0, 1, 2);
        matrix.setelem(0, 2, 3);
        matrix.setelem(1, 1, 4);
        matrix.setelem(1, 2, 5);
        matrix.setelem(2, 2, 6);
        matrix.getDeterminant();
        Matrix matrix1 = new Matrix(3);
        matrix1.setelem(0, 0, 1);
        matrix1.setelem(0, 1, 2);
        matrix1.setelem(0, 2, 3);
        matrix1.setelem(1, 0, 0);
        matrix1.setelem(1, 1, 3);
        matrix1.setelem(1, 2, 0);
        matrix1.setelem(2, 0, 0);
        matrix1.setelem(2, 1, 0);
        matrix1.setelem(2, 2, 8);
        matrix1.getDeterminant();
        DeterminantComparator a = new DeterminantComparator();
        assertEquals(a.compare(matrix1, matrix), 0);
    }

    @Test
    public void sdsd()
    {
        DiagMatrix xx1 = new DiagMatrix(4);
        xx1.setelem(0, 0, 1);
        xx1.setelem(1, 1, -2);
        xx1.setelem(2, 2, -3);
        xx1.setelem(3, 3, 5);
        xx1.getDeterminant();
        System.out.println(xx1.getActualDeterminant());
    }

    @Test
    public void MatrixServiceTest() {
        double[] DiagArr1 = {3, -9, 11};
        DiagMatrix arr1 = new DiagMatrix(DiagArr1);
        arr1.getDeterminant();
        double[] DiagArr2 = {-1, -9, 11};
        DiagMatrix arr2 = new DiagMatrix(DiagArr2);
        arr2.getDeterminant();
        double[] DiagArr3 = {5, 1, 11};
        DiagMatrix arr3 = new DiagMatrix(DiagArr3);
        arr3.getDeterminant();

        IMatrix[] array = {arr1, arr2, arr3};
        IMatrix[] arraySorted = {arr1, arr3, arr2};

        ComparatorDemo.sortProducts(array);
        assertArrayEquals(arraySorted, array);
    }

}
