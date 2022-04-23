package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void whenMoveIsCorrect()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.move(Cell.A1, Cell.C3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException{
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.move(Cell.A2, Cell.C4);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException{
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.add(new BishopBlack(Cell.B2));
        logic.move(Cell.A1, Cell.C3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.move(Cell.A1, Cell.A8);
    }
}