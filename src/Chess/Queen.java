package Chess;

class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.onBoard(chessBoard, line, column, toLine, toColumn)) {
            if ((line != toLine && column != toColumn) && (Math.abs(line - toLine) == Math.abs(column - toColumn)))
                return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
            else if (line != toLine && column == toColumn)
                return onLinePiece(chessBoard, line, column, toLine, toColumn);
            else if (line == toLine && column != toColumn)
                return onColumnPiece(chessBoard, line, column, toLine, toColumn);
            else return false;
        } else return false;
    }

    @Override
    public char getSymbol() {
        if (color.equals("White")) return '\u265B';
        else return '\u2655';
    }
}