public class OX {
    private String[][] table = {
            {" ", "0", "1", "2"},
            {"0" , "-", "-", "-"},
            {"1" , "-", "-", "-"},
            {"2" , "-", "-", "-"}
    };
    private String player  ;
    private int countX ;
    private int countO ;
    private int countDraw ;

    public OX()
    {
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;

    }
    public void resetGame()
    {
        table = new String[][]{
                {" ", "0", "1", "2"},
                {"0", "-", "-", "-"},
                {"1", "-", "-", "-"},
                {"2", "-", "-", "-"}
        };
        player = "X";
    }
    public String getTableString() {
        String  result = "";
        for(int row = 0; row < table.length; row++)
        {
            for(int column = 0; column < table[row].length;column++)
            {
                result = result + table[row][column];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int col, int row) {
        try
        {
            if(!table[row+1][col+1].equals("-"))
            {
                return false;
            }
            table[row+1][col+1] = getCurrentPlayer();
        } catch (ArrayIndexOutOfBoundsException e)
             {
            return false;
             }

        return true;
    }

    public void switchPlayer() {
        if(player == "X")
        {
            player = "O";
        }
        else
        {
            player = "X";
        }
    }

    public boolean checkWin() {

        if(table[1][1].equals("X") && table[1][2].equals("X") && table[1][3].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[2][1].equals("X") && table[2][2].equals("X") && table[2][3].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[3][1].equals("X") && table[3][2].equals("X") && table[3][3].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[1][1].equals("X") && table[2][1] .equals("X") && table[3][1].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[1][2].equals("X") && table[2][2] .equals("X") && table[3][2].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[1][3].equals("X") && table[2][3].equals("X") && table[3][3].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[1][1].equals("X") && table[2][2].equals("X") && table[3][3].equals("X"))
        {
            countX++;
            return true;
        }
        else if(table[1][3].equals("X") && table[2][2].equals("X") && table[3][1].equals("X"))
        {
            countX++;
            return true;
        }
        //---------------------------check O-------------------------------
        if(table[1][1].equals("O") && table[1][2].equals("O") && table[1][3].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[2][1].equals("O") && table[2][2].equals("O") && table[2][3].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[3][1].equals("O") && table[3][2].equals("O") && table[3][3].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[1][1].equals("O") && table[2][1].equals("O") && table[3][1].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[1][2].equals("O") && table[2][2].equals("O") && table[3][2].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[1][3].equals("O") && table[2][3].equals("O") && table[3][3].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[1][1].equals("O") && table[2][2].equals("O") && table[3][3].equals("O"))
        {
            countO++;
            return true;
        }
        else if(table[1][3].equals("O") && table[2][2].equals("O") && table[3][1].equals("O"))
        {
            countO++;
            return true;
        }
        int count = 0;
        for(int i = 0; i < 4;i++)
        {
            for(int j = 0; j < 4; j++ )
            {
                if(table[i][j].equals("-"))
                {
                    count++;
                }
            }
        }
        if(count == 0 )
        {
            countDraw++;
            return true;
        }
        return false;
    }
}
