import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    Cell[][] cells;
    int snakes;
    int ladders;
    int total_cells;

    public Board(int size, int snakes, int ladders) {
        this.size = size;
        this.cells = new Cell[size][size];
        this.snakes = snakes;
        this.ladders = ladders;
        this.total_cells = size*size;
        for(int i = 0; i < size; i++){
            for(int j=0; j < size; j++){
                this.cells[i][j] = new Cell();
            }
        }
        AddLaddersAndSnakes();
    }

    private void AddLaddersAndSnakes() {
        int ladders_added = 0;
        int snakes_added = 0;
        while(ladders_added != this.ladders || snakes_added != this.snakes) {
            int start = ThreadLocalRandom.current().nextInt(1, total_cells-1);
            int end = ThreadLocalRandom.current().nextInt(1, total_cells-1);

            int s_row = start/this.size;
            int s_column = s_row%2 == 0 ? (start%size) : (size - start%size -1);

            int e_row = end/this.size;
            int e_column = e_row%2 == 0? (end%size) : (size - end%size -1);
            if (start < end && ladders_added < this.ladders && !cells[s_row][s_column].IsOccupied()) {
                Jump t_jump = new Jump(start, end);
                ladders_added++;
                cells[s_row][s_column].SetJump(t_jump);
            } else if (start > end && snakes_added < this.snakes && !cells[e_row][e_column].IsOccupied()) {
                Jump t_jump = new Jump(end, start);
                snakes_added++;
                cells[e_row][e_column].SetJump(t_jump);
            }
        }
    }

    public int GetBoardSize() {
        return this.total_cells;
    }

    public Cell GetCell(int row, int column) {
        return this.cells[row][column];
    }
}
