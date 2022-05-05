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
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (line != toLine && column == toColumn) {
                if (line == 1 && color.equals("White") && line + 2 == toLine) return true;
                else if (line == 6 && color.equals("Black") && line - 2 == toLine) return true;
                else if (color.equals("White") && line + 1 == toLine) return true;
                else if (color.equals("Black") && line - 1 == toLine) return true;
                else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}