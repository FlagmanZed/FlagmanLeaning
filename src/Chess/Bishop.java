package Chess;

class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line != toLine && column != toColumn) && (Math.abs(line - toLine) == Math.abs(column - toColumn))) {
            return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        } else return false;
    }

    @Override
    public char getSymbol() {
        if (color.equals("White")) return '\u265D';
        else return '\u2657';
    }
}