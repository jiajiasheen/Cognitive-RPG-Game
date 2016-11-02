package tongzou.cognitivegame.Activity.Class;

/**
 * Created by Draco on 2016-10-31.
 */

public class QuestionRandomGenerator {

    public int[] generator(){
        int[] res = new int[9];
        int trueCount = 3;
        int falseCount = 4;
        int indexCounter = 0;

        res[0] = randomWithRange(0, 9);
        res[1] = randomWithRange(0, 9);

        for (int i = 2; i < res.length; i ++)
        {
            if (randomWithRange(0, 1) == 1)
            {
                res[i] = res[i - 2];
                trueCount --;
            }
            else
            {
                res[i] = randomWithRange(0, 9);
                if (res[i] == res [i - 2])
                {
                    if (res[i] == 9)
                    {
                        res[i] --;
                    }
                    else
                    {
                        res[i] ++;
                    }
                }
                falseCount --;
            }
            if (trueCount == 0 || falseCount == 0)
            {
                indexCounter = i;
                break;
            }
        }

        if (trueCount == 0)
        {
            for (int i = indexCounter + 1; i < res.length; i ++)
            {
                res[i] = randomWithRange(0, 9);
                if (res[i] == res[i - 2])
                {
                    if (res[i] == 9)
                    {
                        res[i] --;
                    }
                    else
                    {
                        res[i] ++;
                    }
                }
            }
        }
        if (falseCount == 0)
        {
            for (int i = indexCounter + 1; i < res.length; i ++)
            {
                res[i] = res[i -2];
            }
        }
        return res;
    }

    private int randomWithRange(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

}
