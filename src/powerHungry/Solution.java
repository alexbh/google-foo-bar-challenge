package powerHungry;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static String solution(int[] xs) {

        List<Integer> panelList  = Arrays.stream(xs)                            //stream array
                                       .limit(50)                               //limit to 50 panels
                                       .filter(item-> Math.abs(item) <= 1000)   //limit do max 1000 abs value
                                       .boxed().collect(Collectors.toList());    //return as list

        //check if number of negative panels are odd or if we have broken panels
        boolean hasBronkenPanels = panelList.stream().anyMatch(item-> item==0);
        long negativeSize = panelList.stream().filter(item-> item < 0).count();
        boolean hasNegativeOdd = negativeSize % 2 != 0;

        //in case of no broken panels or no odd sum of negative panels we need to eliminate at least one, the lowest value of all
        if (!hasBronkenPanels && !hasNegativeOdd) {
            //try to remove the smaller negatives
            BigInteger negativeCase = BigInteger.ZERO;
            if (negativeSize>0) {
                List<Integer> negativeRemoveList = new ArrayList<Integer>(panelList);
                removeItem(negativeRemoveList, returnSmallerNegative(negativeRemoveList));
                removeItem(negativeRemoveList, returnSmallerNegative(negativeRemoveList));
                negativeCase = calculatePanel(negativeRemoveList);
            }

            //try to remove the smaller positive
            List<Integer> positiveRemoveList = new ArrayList<Integer>(panelList);
            removeItem(positiveRemoveList, returnSmallerPositive(positiveRemoveList));
            BigInteger positiveCase = calculatePanel(positiveRemoveList);

            //the biggest one wins
            return positiveCase.compareTo(negativeCase) > 0 ? positiveCase.toString() : negativeCase.toString();
        } else {

            //in case of odd number of negative panels, the smaller one has to go
            if (hasNegativeOdd && panelList.size()>1) {
                panelList.remove(
                    returnSmallerNegative(panelList)                     //get the value to remove from the list
                );
            }

            return calculatePanel(panelList).toString();
        }



    }

    private static BigInteger calculatePanel(List<Integer> panelList) {

        if (panelList.size()==1) return new BigInteger(String.valueOf(panelList.get(0)));

        BigInteger finalResult = panelList.stream()
                                     .filter(item-> item != 0)
                                     .map(x -> new BigInteger(String.valueOf(Math.abs(x))))      //map to bigInteger
                                     .reduce(BigInteger.valueOf(1), (a, b) -> a.multiply(b));    //reduce to final by multiply

        long brokenPanels = panelList.stream().filter(item-> item==0).count();
        if (brokenPanels>=2 && finalResult.compareTo(BigInteger.ONE)==0) {
            finalResult = BigInteger.ZERO;
        }

        return finalResult;
    }

    private static List<Integer> removeItem(List<Integer> painelList, Integer position) {

        if (painelList.size()>=1 && position != null) {
            painelList.remove(position);
        }
        return painelList;
    }

    private static Integer returnSmallerNegative(List<Integer> panelList) {

        if (panelList.stream().filter(item-> item < 0 ).count()>=1) {
            return panelList.stream()
                       .filter(item -> item < 0)
                       .sorted(Comparator.comparingInt(Math::abs))
                       .findFirst().get();
        }
        return -1;
    }

    private static Integer returnSmallerPositive(List<Integer> panelList) {

        if (panelList.stream().filter(item-> item > 0 ).count()>=1) {
            return panelList.stream()
                       .filter(item-> item > 0 )
                       .sorted(Comparator.comparingInt(Math::abs))
                       .findFirst().get();
        }
        return -1;
    }

}
