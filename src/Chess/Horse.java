package Chess;

class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.onBoard(chessBoard, line, column, toLine, toColumn) && onPiece(chessBoard, toLine, toColumn) && (line != toLine && column != toColumn)) {
            if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) return true;
            else return Math.abs(column - toColumn) == 2 && Math.abs(line - toLine) == 1;
        } else return false;
    }

    @Override
    public char getSymbol() {
        if (color.equals("White")) return '\u265E';
        else return '\u2658';
    }
}