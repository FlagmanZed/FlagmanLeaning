package Chess;

import java.util.Scanner;

public abstract class ChessPiece {

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract char getSymbol();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    // проверка поля на наличие своей фигуры
    protected boolean onPiece(ChessBoard board, int toLine, int toColumn) {
        if (board.board[toLine][toColumn] != null) return !board.board[toLine][toColumn].getColor().equals(color);
        else return true;
    }

    // проверка диагонали на наличие фигур
    protected boolean onDiagonalPiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countDiagPiece = 0;
        for (int i = 1; i <= Math.abs(line - toLine); i++) {
            if (line > toLine && column > toColumn && board.board[line - i][column - i] != null)
                countDiagPiece++;
            else if (line < toLine && column > toColumn && board.board[line + i][column - i] != null)
                countDiagPiece++;
            else if (line < toLine && column < toColumn && board.board[line + i][column + i] != null)
                countDiagPiece++;
            else if (line > toLine && column < toColumn && board.board[line - i][column + i] != null)
                countDiagPiece++;
        }
        if (countDiagPiece > Math.abs(line - toLine)) return true;
        else if (countDiagPiece == 0 && (getSymbol() == '\u265F' || getSymbol() == '\u2659'))                            //исключение для пешки
            return false;
        else if (countDiagPiece == 0) return true;
        else return countDiagPiece == 1 && onPiece(board, toLine, toColumn);
    }

    // проверка столбца на наличие фигур
    protected boolean onColumnPiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countColumnPiece = 0;
        for (int i = 1; i <= Math.abs(line - toLine); i++) {
            if (line > toLine && board.board[line - i][column] != null)
                countColumnPiece++;
            else if (line < toLine && board.board[line + i][column] != null)
                countColumnPiece++;
        }
        if (countColumnPiece > Math.abs(line - toLine)) return true;
        else if (countColumnPiece == 0) return true;
        else if (countColumnPiece == Math.abs(line - toLine) && (getSymbol() == '\u265F' || getSymbol() == '\u2659'))
            return false;
        else return countColumnPiece == 1 && onPiece(board, toLine, toColumn);
    }

    // проверка линии на наличие фигур
    protected boolean onLinePiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countLinePiece = 0;
        for (int i = 1; i <= Math.abs(column - toColumn); i++) {
            if (column > toColumn && board.board[line][column - i] != null)
                countLinePiece++;
            else if (column < toColumn && board.board[line][column + i] != null)
                countLinePiece++;
        }
        if (countLinePiece > Math.abs(column - toColumn)) return true;
        else if (countLinePiece == 0 && board.board[line][column].check && Math.abs(column - toColumn) == 2
                && (getSymbol() == '\u265A' || getSymbol() == '\u2654'))
            return true;
        else if (countLinePiece == 0) return true;
        else return countLinePiece == 1 && onPiece(board, toLine, toColumn);
    }

    public static ChessPiece choicePiece(String color) {
        ChessPiece piece;
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите фигуру: 1. Ферзь\t2. Ладья\t3. Слон\t4. Конь\t");
        char choice = scan.next().charAt(0);
        switch (choice) {
            case '1' -> piece = new Queen(color);
            case '2' -> piece = new Rook(color);
            case '3' -> piece = new Bishop(color);
            case '4' -> piece = new Horse(color);
            default -> piece = new Queen(color);
        }
        return piece;
    }
}
