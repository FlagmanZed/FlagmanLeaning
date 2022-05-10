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
        if (line != toLine && column != toColumn && Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1)
            return onDiagonalPiece(chessBoard, line, column, toLine, toColumn);
        else if (line != toLine && column == toColumn && Math.abs(line - toLine) == 1)
            return onColumnPiece(chessBoard, line, column, toLine, toColumn);
        else if (column != toColumn && line == toLine && Math.abs(column - toColumn) == 1)
            return onLinePiece(chessBoard, line, column, toLine, toColumn);
        else return false;
    }

    @Override
    public char getSymbol() {
        if (color.equals("White")) return '\u265A';
        else return '\u2654';
    }

    boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                    if (!board.board[i][j].getColor().equals(color) && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}