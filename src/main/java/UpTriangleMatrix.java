public class UpTriangleMatrix implements IMatrix
{
    private double[] matrix;
    private int size;
    private Double actualDeterminant;
    private boolean flag;
    public UpTriangleMatrix(int size)
    {
        if(size<0)
        {
            throw new IllegalArgumentException("Размер не может быть отрицательным, олень");
        }
        int dopSize = 0;
        for(int i = size; i>0; i--)
        {
            dopSize = dopSize + size;
        }
        this.size = size;
        flag = false;
        matrix = new double[dopSize];
    }

    @Override
    public double getElemByIndex(int i, int j) {
        if(i>j && i<size && j<size && i>=0 && j>=0)
        {
            return 0;
        }
            Double x = matrix[size*i+j-i*(i+1)/2];
        return x.doubleValue();
    }

    public void setelem(int i, int j, double x)
    {
        if(i>j && i<size && j<size && i>=0 && j>=0)
        {
            throw new IllegalArgumentException("Не, ну это совсем чушшшш");
        }
        matrix[size*i+j-i*(i+1)/2] = x;
        flag = false;

    }

    @Override
    public void getDeterminant()
    {
        if(flag == false) {
            double x = 1;
            for (int i = 0; i < size; i++) {
                x = matrix[size*i+i-i*(i+1)/2] * x;
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
