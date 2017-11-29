public class KnightTour
{
    private static final int N = 8;
    private int chessboard[][];
 
    public KnightTour()
    {
        chessboard = new int[N][N];
    }
 
    private boolean isValid(int x, int y)
    {
        if (x >= 0 && x < N && y >= 0 && y < N && chessboard[x][y] == -1)
            return true;
        return false;
    }
 
    private void print()
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                System.out.print("  " + chessboard[x][y]);
            }
            System.out.println();
        }
    }
 
    private boolean knightMove(int x, int y, int movei, int vertical[],int horizontal[])
    {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
 
        for (k = 0; k < N; k++)
        {
            next_x = x + vertical[k];
            next_y = y + horizontal[k];
            if (isValid(next_x, next_y))
            {
                chessboard[next_x][next_y] = movei;
                if (knightMove(next_x, next_y, movei + 1, vertical, horizontal))
                    return true;
                else
                    chessboard[next_x][next_y] = -1;
            }
        }
        return false;
    }
 
    public boolean solveKnightTour()
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                chessboard[x][y] = -1;
            }
        }
        int vertical[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int horizontal[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        chessboard[0][0] = 0;
        if (!knightMove(0, 0, 1, vertical, horizontal))
        {
            System.out.println("the solution does not exist");
            return false;
        }
        else
        {
            print();
        }
        return true;
    }
 
    public static void main(String[] args)
    {
        KnightTour knightTour = new KnightTour();
        System.out.println("Here is the knight's tour:");
        knightTour.solveKnightTour();
    }
}

