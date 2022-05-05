package Chess;

class King extends ChessPiece {
    public King(String color) {
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
                if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1) return true;
                else return false;
            } else if (line != toLine && Math.abs(line - toLine) == 1) {
                return true;
            } else if (column != toColumn && Math.abs(column - toColumn) == 1) {
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.board[i][j] != null) {
                    if (board.board[i][j].getColor().equals(color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}