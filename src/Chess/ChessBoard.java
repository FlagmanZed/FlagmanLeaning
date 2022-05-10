package Chess;


public class ChessBoard {

    public ChessPiece[][] board = new ChessPiece[8][8];
    public ChessPiece[][] copy = new ChessPiece[8][8];
    String nowPlayer;
    int lineKing = 0;
    int columnKing = 0;
    boolean isKing;
    int countMoveIsCheck = 0;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (onBoard(startLine, startColumn, endLine, endColumn)) {
            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;
            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                if (board[startLine][startColumn].getSymbol() == '\u265F' && endLine == 7) {
                    board[endLine][endColumn] = ChessPiece.choicePiece("White");
                    board[endLine][endColumn].check = false;
                    board[startLine][startColumn] = null;
                } else if (board[startLine][startColumn].getSymbol() == '\u2659' && endLine == 0) {
                    board[endLine][endColumn] = ChessPiece.choicePiece("Black");
                    board[endLine][endColumn].check = false;
                    board[startLine][startColumn] = null;
                } else {
                    board[endLine][endColumn] = board[startLine][startColumn];
                    board[endLine][endColumn].check = false;
                    board[startLine][startColumn] = null;
                }
                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    // проверка выхода за пределы доски
    boolean onBoard(int line, int column, int toLine, int toColumn) {
        return (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn));
    }

    // рокировка к столбцу 0
    boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (board[0][0] == null || board[0][4] == null) return false;
            if (board[0][0].getSymbol() == '\u265C' && board[0][4].getSymbol() == '\u265A' && // check that King and Rook
                    board[0][1] == null && board[0][2] == null && board[0][3] == null) {              // never moved
                if (board[0][0].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 2) &&
                        !new King("White").isUnderAttack(this, 0, 3)) { // check that position not in under attack
                    board[0][4] = null;
                    board[0][2] = new King("White");   // move King
                    board[0][2].check = false;
                    board[0][0] = null;
                    board[0][3] = new Rook("White");   // move Rook
                    board[0][3].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][0] == null || board[7][4] == null) return false;
            if (board[7][0].getSymbol() == '\u2656' && board[7][4].getSymbol() == '\u2654' && // check that King and Rook
                    board[7][1] == null && board[7][2] == null && board[7][3] == null) {              // never moved
                if (board[7][0].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 2) &&
                        !new King("Black").isUnderAttack(this, 7, 3)) { // check that position not in under attack
                    board[7][4] = null;
                    board[7][2] = new King("Black");   // move King
                    board[7][2].check = false;
                    board[7][0] = null;
                    board[7][3] = new Rook("Black");   // move Rook
                    board[7][3].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }

    // рокировка к столбцу 7
    boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (board[0][7] == null || board[0][4] == null) return false;
            if (board[0][7].getSymbol() == '\u265C' && board[0][4].getSymbol() == '\u265A' && // check that King and Rook
                    board[0][6] == null && board[0][5] == null) {              // never moved
                if (board[0][7].check && board[0][4].check &&
                        !new King("White").isUnderAttack(this, 0, 6) &&
                        !new King("White").isUnderAttack(this, 0, 5)) { // check that position not in under attack
                    board[0][4] = null;
                    board[0][6] = new King("White");   // move King
                    board[0][6].check = false;
                    board[0][7] = null;
                    board[0][5] = new Rook("White");   // move Rook
                    board[0][5].check = false;
                    nowPlayer = "Black";  // next turn
                    return true;
                } else return false;
            } else return false;
        } else {
            if (board[7][7] == null || board[7][4] == null) return false;
            if (board[7][7].getSymbol() == '\u2656' && board[7][4].getSymbol() == '\u2654' && // check that King and Rook
                    board[7][6] == null && board[7][5] == null) {              // never moved
                if (board[7][7].check && board[7][4].check &&
                        !new King("Black").isUnderAttack(this, 7, 6) &&
                        !new King("Black").isUnderAttack(this, 7, 5)) { // check that position not in under attack
                    board[7][4] = null;
                    board[7][6] = new King("Black");   // move King
                    board[7][6].check = false;
                    board[7][7] = null;
                    board[7][5] = new Rook("Black");   // move Rook
                    board[7][5].check = false;
                    nowPlayer = "White";  // next turn
                    return true;
                } else return false;
            } else return false;
        }
    }

    // определение позиции короля
    void whereKing() {
        lineKing = 0;
        columnKing = 0;
        isKing = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if ((board[i][j] != null && board[i][j].getSymbol() == '\u265A' || board[i][j].getSymbol() == '\u2654')
                            && board[i][j].getColor().equals(nowPlayer)) {
                        columnKing = j;
                        isKing = true;
                        break;
                    }
                }
            }
            if (isKing) {
                lineKing = i;
                break;
            }
        }
    }

    // проверка объявления шаха
    boolean isCheck() {
        whereKing();
        return new King(nowPlayer).isUnderAttack(this, lineKing, columnKing);
    }

    // проверка возможности хода при объявленном шахе
    boolean canMoveIsCheck(int startLine, int startColumn, int endLine, int endColumn) {
        for (int i = 0; i < 8; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 8);
        }
        if (moveToPosition(startLine, startColumn, endLine, endColumn)) {
            if (!isCheck()) {
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                return true;
            } else {
                System.out.println("Так ходить нельзя, король под ударом!");
                for (int i = 0; i < 8; i++) {
                    System.arraycopy(copy[i], 0, board[i], 0, 8);
                }
                return false;
            }
        } else return false;
    }

    // проверка количества возможных вариантов вывести короля из под боя
    void mate() {
        countMoveIsCheck = 0;
        for (int a = 0; a < 8; a++) {
            System.arraycopy(board[a], 0, copy[a], 0, 8);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (board[i][j] != null)
                            if (moveToPosition(i, j, k, l)) {
//                                System.out.println(i + "" + j + " " + k + "" + l);                                     // вывести на экран возможные ходы
                                if (!isCheck())
                                    countMoveIsCheck++;
                                for (int a = 0; a < 8; a++) {
                                    System.arraycopy(copy[a], 0, board[a], 0, 8);
                                }
                            }
                    }
                }
            }
        }
//        System.out.println(countMoveIsCheck);                                                                          // вывести на экран количество возможных ходов
    }

    // проверка объявления мата
    boolean isMate() {
        mate();
        return countMoveIsCheck == 0;
    }
}
