import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    public void shouldCreateOXObjectCorrectly() {
        OX ox = new OX();
        // " 012\n0---\n1---\n2---\n"
        assertEquals(" 012\n0---\n1---\n2---\n", ox.getTableString());
        assertEquals("X",ox.getCurrentPlayer());
        assertEquals(0,ox.getCountO());
        assertEquals(0,ox.getCountX());
        assertEquals(0,ox.getCountDraw());
    }
    @Test
    public void put(){
        OX ox = new OX();
        ox.put(1,1);
        assertEquals(" 012\n0---\n1-X-\n2---\n",ox.getTableString());

        ox.put(0,0);
        assertEquals(" 012\n0X--\n1-X-\n2---\n",ox.getTableString());

        ox.put(2,1);
        assertEquals(" 012\n0X--\n1-XX\n2---\n",ox.getTableString());

        ox.switchPlayer();
        ox.put(0,2);
        assertEquals(" 012\n0X--\n1-XX\n2O--\n",ox.getTableString());

        assertFalse(ox.put(0, 2));

        assertFalse(ox.put(3, 2));
    }
    @Test
    public void switchPlayer()
    {
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals("O",ox.getCurrentPlayer());
        ox.switchPlayer();
        assertEquals("X",ox.getCurrentPlayer());
    }
    @Test
    public void checkWin1()
    {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(" 012\n0X--\n1X--\n2X--\n",ox.getTableString());
        assertTrue(ox.checkWin());
    }



    @Test
    public void resetTable()
    {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        assertEquals(" 012\n0X--\n1X--\n2---\n",ox.getTableString());
        ox.resetGame();
        assertEquals(" 012\n0---\n1---\n2---\n", ox.getTableString());
        assertEquals("X",ox.getCurrentPlayer());
    }
    @Test
    public void checkDraw()
    {
        OX ox = new OX();
        ox.put(0,0);//X
        ox.switchPlayer();
        ox.put(1,0);//O
        ox.switchPlayer();
        ox.put(2,0);//X
        ox.switchPlayer();
        ox.put(0,1);//O
        ox.switchPlayer();
        ox.put(2,1);//X
        ox.switchPlayer();
        ox.put(1,1);//O
        ox.switchPlayer();
        ox.put(0,2);//X
        ox.switchPlayer();
        ox.put(2,2);//O
        ox.switchPlayer();
        ox.put(1,2);//X
        ox.checkWin();
        assertEquals(" 012\n0XOX\n1OOX\n2XXO\n", ox.getTableString());
        assertEquals(1,ox.getCountDraw());
    }
}
