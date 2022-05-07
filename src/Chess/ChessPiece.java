package Chess;

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
                countDiagPiece = i;
            else if (line < toLine && column > toColumn && board.board[line + i][column - i] != null)
                countDiagPiece = i;
            else if (line < toLine && column < toColumn && board.board[line + i][column + i] != null)
                countDiagPiece = i;
            else if (line > toLine && column < toColumn && board.board[line - i][column + i] != null)
                countDiagPiece = i;
        }
        if (countDiagPiece > Math.abs(line - toLine)) return true;
        else if (countDiagPiece == 0 && (getSymbol() == '\u265F' || getSymbol() == '\u2659')) return false;
        else if (countDiagPiece == 0) return true;
        else return countDiagPiece == Math.abs(line - toLine) && onPiece(board, toLine, toColumn);
    }

    // проверка линий на наличие фигур
    protected boolean onLinePiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countLinePiece = 0;
        for (int i = 1; i <= Math.abs(line - toLine); i++) {
            if (line > toLine && board.board[line - i][column] != null)
                countLinePiece = i;
            else if (line < toLine && board.board[line + i][column] != null)
                countLinePiece = i;
        }
        if (countLinePiece > Math.abs(line - toLine)) return true;
        else if (countLinePiece == 0) return true;
        else if (countLinePiece == Math.abs(line - toLine) && (getSymbol() == '\u265F' || getSymbol() == '\u2659'))
            return false;
        else return countLinePiece == Math.abs(line - toLine) && onPiece(board, toLine, toColumn);
    }

    // проверка столбцов на наличие фигур
    protected boolean onColumnPiece(ChessBoard board, int line, int column, int toLine, int toColumn) {
        int countColumnPiece = 0;
        for (int i = 1; i <= Math.abs(column - toColumn); i++) {
            if (column > toColumn && board.board[line][column - i] != null)
                countColumnPiece = i;
            else if (column < toColumn && board.board[line][column + i] != null)
                countColumnPiece = i;
        }
        if (countColumnPiece > Math.abs(column - toColumn)) return true;
        else if (countColumnPiece == 0) return true;
        else return countColumnPiece == Math.abs(column - toColumn) && onPiece(board, toLine, toColumn);
    }

}