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
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line != toLine && column != toColumn) {
                if (Math.abs(line - toLine) == Math.abs(column - toColumn)) return true;
                else return false;
            } else if (line == toLine && column == toColumn){
                return false;
            } else return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}