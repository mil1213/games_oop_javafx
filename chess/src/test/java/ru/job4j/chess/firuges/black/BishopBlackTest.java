package ru.job4j.chess.firuges.black;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenPositionCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        assertThat(bishopBlack.position(), is (Cell.A3));
    }

    @Test
    public void whenCopyCorrect() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        assertThat(bishopBlack.copy(Cell.C7).position(), is(Cell.C7));
    }

   @Test
    public void whenWayCorrectC1G5() {
       BishopBlack bishopBlack = new BishopBlack(Cell.C1);
       Cell[] exp = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
       assertThat(bishopBlack.way(Cell.G5), is (exp));
    }

    @Test
    public void whenWayCorrectB8E5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Cell[] exp = {Cell.C7, Cell.D6, Cell.E5};
        assertThat(bishopBlack.way(Cell.E5), is (exp));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenWayIsNotDiagonal () {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        bishopBlack.way(Cell.B6);
    }
}