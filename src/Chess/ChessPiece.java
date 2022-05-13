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

    // проверка поля на наличие фигуры противника
    protected boolean onPiece(ChessBoard board, int toLine, int toColumn) {
        if (board.board[toLine][toColumn] != null) return !board.board[toLine][toColumn].getColor().equals(color);
        else return true;
    }

    // проверка диагонали на наличие фигур
    protected boolean onDiagonalPiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countOnDiagPiece = 0, lastPieceDiag = 0;
        for (int i = 1; i <= Math.abs(line - toLine); i++) {
            if (line > toLine && column > toColumn && board.board[line - i][column - i] != null) {
                countOnDiagPiece++;
                lastPieceDiag = i;
            } else if (line < toLine && column > toColumn && board.board[line + i][column - i] != null) {
                countOnDiagPiece++;
                lastPieceDiag = i;
            } else if (line < toLine && column < toColumn && board.board[line + i][column + i] != null) {
                countOnDiagPiece++;
                lastPieceDiag = i;
            } else if (line > toLine && column < toColumn && board.board[line - i][column + i] != null) {
                countOnDiagPiece++;
                lastPieceDiag = i;
            }
        }
        if (countOnDiagPiece > 1) return false;
        if (countOnDiagPiece == 1) {
            if (lastPieceDiag != Math.abs(line - toLine)) return false;
            else return onPiece(board, toLine, toColumn);
        } else {
            if (getSymbol() == '\u265F' || getSymbol() == '\u2659') return false;
            else return true;
        }
    }

    // проверка столбца на наличие фигур
    protected boolean onColumnPiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countOnColumnPiece = 0, lastPieceLine = 0;
        for (int i = 1; i <= Math.abs(line - toLine); i++) {
            if (line > toLine && board.board[line - i][column] != null) {
                countOnColumnPiece++;
                lastPieceLine = i;
            } else if (line < toLine && board.board[line + i][column] != null) {
                countOnColumnPiece++;
                lastPieceLine = i;
            }
        }
        if (countOnColumnPiece > 1) return false;

        if (countOnColumnPiece == 1) {
            if (getSymbol() == '\u265F' || getSymbol() == '\u2659') return false;
            else {
                if (lastPieceLine != Math.abs(line - toLine)) return false;
                else return onPiece(board, toLine, toColumn);
            }
        } else return true;
    }

    // проверка линии на наличие фигур
    protected boolean onLinePiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countOnLinePiece = 0, lastPieceColumn = 0;
        for (int i = 1; i <= Math.abs(column - toColumn); i++) {
            if (column > toColumn && board.board[line][column - i] != null) {
                countOnLinePiece++;
                lastPieceColumn = i;
            } else if (column < toColumn && board.board[line][column + i] != null) {
                countOnLinePiece++;
                lastPieceColumn = i;
            }
        }
        if (countOnLinePiece > 1) return false;
        if (countOnLinePiece == 1) {
            if (lastPieceColumn != Math.abs(column - toColumn)) return false;
            else return onPiece(board, toLine, toColumn);
        } else return true;
    }

    // превращение пешки в выбранную фигуру
    protected static ChessPiece choicePiece(String color) {
        ChessPiece piece;
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Выберите фигуру:
                '1'                     - Ладья
                '2'                     - Слон
                '3'                     - Конь
                'любой другой символ'   - Ферзь""");
        char choice = scan.next().charAt(0);
        switch (choice) {
            case '1' -> piece = new Rook(color);
            case '2' -> piece = new Bishop(color);
            case '3' -> piece = new Horse(color);
            default -> piece = new Queen(color);
        }
        return piece;
    }
}
