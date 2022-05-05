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
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line != toLine && column != toColumn) {
                if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) return true;
                else if (Math.abs(column - toColumn) == 2 && Math.abs(line - toLine) == 1) return true;
                else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}