import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int number_of_dice;

    public Dice(int dice_number) {
        this.number_of_dice = dice_number;
    }

    public int RollDice() {
        int total = 0;
        int dice_rolls = 0;
        while(dice_rolls != this.number_of_dice) {
            int cur_dice_roll = ThreadLocalRandom.current().nextInt(1,6);
            total += cur_dice_roll;
            dice_rolls ++;
        }
        return total;
    }
}
