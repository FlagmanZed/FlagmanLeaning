package Chess;

class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column == toColumn) {
            if (line == 1 && color.equals("White") && line + 2 == toLine)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            else if (line == 6 && color.equals("Black") && line - 2 == toLine)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            else if (color.equals("White") && line + 1 == toLine)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            else if (color.equals("Black") && line - 1 == toLine)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            else return false;
        } else {
            if (color.equals("White") && line - toLine == -1 && Math.abs(column - toColumn) == 1)
                return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
            else if (color.equals("Black") && line - toLine == 1 && Math.abs(column - toColumn) == 1)
                return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
            else return false;
        }
    }

    @Override
    public char getSymbol() {
        if (color.equals("White")) return '\u265F';
        else return '\u2659';
    }
}