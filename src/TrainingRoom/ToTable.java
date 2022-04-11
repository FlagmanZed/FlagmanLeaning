package TrainingRoom;

class ToTable {
    int[] data;
    int x, y;

    public ToTable(int[] data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    int[][] resize() {

        int[][] res = new int[x][y];
        int start = 0;
        for (int i = 0; i < x; i++) {
            for (int j = start; j < start + y; j++) {
                res[i][j - start] = data[j];
            }
            start += y;
        }
        return res;
    }
}