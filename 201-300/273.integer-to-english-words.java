/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    private String oneDigit(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private String lessThan20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }



    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();

        int billion = num / 1000000000;
        int million = num % 1000000000 / 1000000;
        int thousand = num % 1000000 / 1000;
        int hundred = num % 1000 / 100;
        int ten = num % 100 / 10;
        int rem = num % 10;

        if (billion != 0) {
            words.append(oneDigit(billion));
            words.append(" Billion ");
        }

        if (million != 0) {
            words.append(numberToWords(million));
            words.append(" Million ");
        }

        if (thousand != 0) {
            words.append(numberToWords(thousand));
            words.append(" Thousand ");
        }

        if (hundred != 0) {
            words.append(oneDigit(hundred));
            words.append(" Hundred ");
        }

        if (ten == 1) {
            words.append(lessThan20(ten * 10 + rem));
            words.append(" ");
        } else {
            if (ten != 0) {
                words.append(ten(ten));
                words.append(" ");
            }

            if (rem != 0) {
                words.append(oneDigit(rem));
                words.append(" ");
            }
        }

        return words.toString().trim();
    }
}
// @lc code=end

