public interface IMatrix
{
    double getElemByIndex(int i, int j);
    void setelem(int i, int j, double x);
    void getDeterminant();
    Double getActualDeterminant();
}
