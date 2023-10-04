import java.sql.ResultSet;

public class DiagMatrix implements IMatrix
{
    private double[] matrix;
    private int size;
    private Double actualDeterminant;
    private boolean flag;

    public DiagMatrix(int size)
    {
        if(size<0)
        {
            throw new IllegalArgumentException("Неверный размер");
        }
        this.size = size;
        matrix = new double[size];
        flag = false;
    }
    public DiagMatrix(double[] diag)
    {
        if(diag != null)
        {
            size = diag.length;
            matrix = new double[size];
            for (int i = 0; i < size; i++) {
                matrix[i] = diag[i];
            }
        } else
            throw new IllegalArgumentException("Закинули пустой массив");
    }

    @Override
    public double getElemByIndex(int i, int j) {
        if(i>=0 && j>=0 && i<size && j<size)
            if(i == j)
            return matrix[i];
            else
                return 0.;
        else throw new IllegalArgumentException("Метки неверны");
    }

    @Override
    public void setelem(int i, int j, double x) {
        if(i == j) {
            matrix[i] = x;
            flag = false;
        }
        else
            throw new IllegalArgumentException("Нельзя, козел тупой, урод, ничтожество");
    }

    @Override
    public void getDeterminant()
    {
        if(flag == false) {
            double x = 1;
            for (int i = 0; i < size; i++) {
                x = matrix[i] * x;
            }
            actualDeterminant = x;
            flag = true;
        }

    }

    public Double getActualDeterminant() {
        if(actualDeterminant != null)
        return actualDeterminant;
        else
            throw new IllegalArgumentException("Вы еще не считали определитель. Вы самый конченый пользователь");
    }
}
