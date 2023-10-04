import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix
{
    private int size;
    private double[] matrix;
    private Double determinant;
    private boolean flag;
    public Matrix(int size)
    {
        if(size>0) {
            this.size = size;
            matrix = new double[size*size];
        } else
        {
            throw new IllegalArgumentException("Wrong size");
        }
        flag = false;
    }
    public Matrix(final Matrix katrix)
    {
        size = katrix.getSize();
        matrix = new double[size];
        for (int i = 0; i<getSize(); i++)
        {
            this.matrix[i] = matrix[i];
        }

    }
    @Override
    public double getElemByIndex(int i, int j) {
        if(i>=0 && j>=0 && i<size && j<size)
        return matrix[i*size+j];
        else throw new IllegalArgumentException("Метки неверны");
    }

    @Override
    public void setelem(int i, int j, double x) {
        if(i<size && j<size && i>=0 && j>=0) {
            matrix[i * size + j] = x;
            flag = false;
        }
        else
            throw new IllegalArgumentException("Забыл какие у твоей матрицы размеры!? Кретин");
    }

    @Override
    public void getDeterminant()
    {
        if(flag == false) {
            double det = 1;
            double max;
            int r;
            for (int k = 0; k < size; k++) {
                max = Math.abs(matrix[k * size + k]);
                r = k;
                for (int i = k + 1; i < size; i++) {
                    if (Double.compare(matrix[i * size + k], max) == 1) {
                        max = Math.abs(matrix[i * size + k]);
                        r = i;
                    }
                }
                if (r != k) {
                    det = -det;
                }
                double c;
                for (int j = 0; j < size; j++) {
                    c = matrix[k * size + j];
                    matrix[k * size + j] = matrix[r * size + j];
                    matrix[r * size + j] = c;
                }
                double M;
                for (int i = k + 1; i < size; i++) {
                    M = matrix[i * size + k];
                    for (int j = k; j < size; j++)
                        matrix[i * size + j] = matrix[i * size + j] - M * matrix[k * size + j];
                }
            }
            for (int i = 0; i < size; i++) {
                det = det * matrix[i * size + i];
            }
            flag = true;
            determinant = det;
        }
    }

    @Override
    public Double getActualDeterminant() {
        if(determinant != null)
            return determinant;
        else
            throw new IllegalArgumentException("Кеш пуст");
    }


    public int getSize() {
        return size;
    }
}
