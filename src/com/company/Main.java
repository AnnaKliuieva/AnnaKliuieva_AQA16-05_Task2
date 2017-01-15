package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int numbDiffDigits(String k) {
        StringBuilder uniNumb = new StringBuilder();
        String currNumb;
        for (int i = 0; i < k.length(); i++) {
            currNumb = String.valueOf(k.charAt(i));
            if (uniNumb.indexOf(currNumb) == -1) {
                uniNumb.append(currNumb);
            }
        }
        return uniNumb.length();
    }

    private static boolean numbWithEvenOddEq(String k) {
        int even = 0, odd = 0;
        for (int i = 0; i < k.length(); i++) {
            if (Character.getNumericValue(k.charAt(i)) % 2 == 0)
                even++;
            else odd++;
        }
        return (even == odd);
    }

    private static boolean numbWithDiffDigits(String k) {
        for (int i = 0; i < k.length() - 1; i++) {
            for (int j = 1; j < k.length(); j++) {
                if (k.charAt(i) == k.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void copyNbyNmatrix(int[][] arr, int[][] arr1) {
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = (int[]) arr[i].clone();
        }
    }

    private static void matrixColumnIncrSort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] > arr[k][j]) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[k][j];
                        arr[k][j] = temp;
                    }
                }
            }
        }
    }

    private static void matrixRightShift(int[][] arr, int shift) {
        for (int k = 0; k < shift; k++) {
            for (int i = 0; i < arr.length; i++) {
                int tmp = arr[i][arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = tmp;
            }
        }
    }

    private static void matrixLeftShift(int[][] arr, int shift) {
        for (int k = 0; k < shift; k++) {
            for (int i = 0; i < arr.length; i++) {
                int tmp = arr[i][0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][arr.length - 1] = tmp;
            }
        }
    }

    private static void matrixShiftUp(int[][] arr, int shift) {
        for (int k = 0; k < shift; k++) {
            int[] tmp = arr[0].clone();
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = tmp;
        }
    }

    private static void matrixShiftDown(int[][] arr, int shift) {
        for (int k = 0; k < shift; k++) {
            int[] tmp = arr[arr.length - 1].clone();
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
        }
    }

    private static void maxIncrDecrSequence(int[][] arr) {
        int[] arrToString = new int[arr.length * arr.length];
        int count = 0, maxSeqLen = 0, minSeqLen = 0, currIndForMax = 0, currIndForMin = 0, maxCount = 1, minCount = 1;
        for (int[] x : arr) {
            for (int y : x)
                arrToString[count++] = y;
        }

        for (int j = 0; j < arrToString.length - 1; j++) {

            if (arrToString[j] <= arrToString[j + 1]) {
                maxCount += 1;
                if (maxCount > maxSeqLen) {
                    maxSeqLen = maxCount;
                    currIndForMax = j + 1;
                }
            } else
                maxCount = 1;

            if (arrToString[j] >= arrToString[j + 1]) {
                minCount += 1;
                if (minCount > minSeqLen) {
                    minSeqLen = minCount;
                    currIndForMin = j + 1;
                }
            } else
                minCount = 1;

        }
        System.out.println(Arrays.toString(arrToString));
        System.out.println("Максимальная возрастающая числовая последовательность:");
        int[] arrMaxSeq = new int[maxSeqLen];
        System.arraycopy(arrToString, (currIndForMax - maxSeqLen + 1), arrMaxSeq, 0, (maxSeqLen));
        System.out.println(Arrays.toString(arrMaxSeq) + " " + (maxSeqLen));
        System.out.println("Максимальная убывающая числовая последовательность:");
        int[] arrMinSeq = new int[minSeqLen];
        System.arraycopy(arrToString, (currIndForMin - minSeqLen + 1), arrMinSeq, 0, (minSeqLen));
        System.out.println(Arrays.toString(arrMinSeq) + " " + (minSeqLen));
    }

    private static void matrixRot90(int[][] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = i; j < arr.length - 1 - i; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][arr.length - 1 - i];
                arr[j][arr.length - 1 - i] = arr[arr.length - 1 - i][arr.length - 1 - j];
                arr[arr.length - 1 - i][arr.length - 1 - j] = arr[arr.length - 1 - j][i];
                arr[arr.length - 1 - j][i] = tmp;
            }
        }
    }

    private static double avrgValueOfMatrix(int[][] arr) {
        double sum = 0;
        for (int[] x : arr) {
            for (int y : x) {
                sum += y;
            }
        }
        return sum / (arr.length * arr.length);
    }


    public static void main(String[] args) {
        /*
        //  Ввести с консоли n целых чисел.

        System.out.println("Введите N целых чисел через пробел. Для окончания ввода нажмите 'Enter':");
        Scanner inputScan = new Scanner(System.in);
        String[] chain = inputScan.nextLine().split(" ");
        inputScan.close();

        // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        String theLongest = null, theShortest = null;
        int min = Integer.MAX_VALUE, max = 0;
        for (String i : chain) {
            if (i.length() < min) {
                min = i.length();
                theShortest = i;
            }
            if (i.length() > max) {
                max = i.length();
                theLongest = i;
            }
        }
        System.out.println("Самое короткое число " + theShortest + ". Его длина составляет " + min + ".");
        System.out.println("Самое длинное число " + theLongest + ". Его длина составляет " + max + ".");

        // 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.

        String[] chainIncr = new String[chain.length];
        System.arraycopy(chain, 0, chainIncr, 0, chain.length);

        for (int barier = chainIncr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (chainIncr[i].length() > chainIncr[i + 1].length()) {
                    String temp = chainIncr[i];
                    chainIncr[i] = chainIncr[i + 1];
                    chainIncr[i + 1] = temp;
                }
            }
        }
        System.out.println("Сортировка массива по возрастанию длин чисел: " + Arrays.toString(chainIncr));

        String[] chainDicr = new String[chain.length];
        System.arraycopy(chain, 0, chainDicr, 0, chain.length);
        for (int barier = chainDicr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (chainDicr[i].length() < chainDicr[i + 1].length()) {
                    String temp = chainDicr[i];
                    chainDicr[i] = chainDicr[i + 1];
                    chainDicr[i + 1] = temp;
                }
            }
        }
        System.out.println("Сортировка массива по убыванию длин чисел: " + Arrays.toString(chainDicr));

        // 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.

        int sum = 0;
        for (String k : chain) {
            sum += k.length();
        }
        int average = sum / chain.length;
        System.out.println("Среднее значение длины чисел: " + average);

        System.out.println("Числа, длина которых меньше средней: ");

        for (String k : chain) {
            if (k.length() < average)
                System.out.println("  число - " + k + ", длина этого числа - " + k.length());
        }

        System.out.println("Числа, длина которых больше средней: ");

        for (String k : chain) {
            if (k.length() > average)
                System.out.println("  число - " + k + ", длина этого числа - " + k.length());
        }

        // 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.

        String minDiff = chain[0];
        for (int i = 1; i < chain.length; i++) {
            if (numbDiffDigits(minDiff) > numbDiffDigits(chain[i])) {
                minDiff = chain[i];
            }
        }
        System.out.println("Число с минимальным набором различных цифр " + minDiff);

        // 5. Найти количество чисел, содержащих только четные цифры,
        //    а среди них количество чисел с равным числом четных и нечетных цифр.

        ArrayList<String> selectedEven = new ArrayList<>();
        int numbOfEven = 0;
        for (String k : chain) {
            if (Integer.parseInt(k) % 2 == 0) {
                numbOfEven++;
                selectedEven.add(k);
            }
        }
        System.out.println("Количество введенных четных чисел равно " + numbOfEven);

        System.out.print("Числа с равным количеством четных и нечетных цифр: ");
        int numbCount = 0;
        for (String k : selectedEven) {
            if (numbWithEvenOddEq(k)) {
                System.out.print(k + " ");
                numbCount++;
            }
        }
        System.out.println(". Всего таких чисел " + numbCount);

        // 6. Найти число, цифры в котором идут в строгом порядке возрастания.
        //    Если таких чисел несколько, найти первое из них.

        for (String k : chain) {
            byte[] a = k.getBytes();
            byte[] b = k.getBytes();
            Arrays.sort(b);
            if (Arrays.equals(a, b)){
                System.out.println("Число, цифры в котором следуют по возрастанию их значения " + k);
                break;
            }
        }

        // 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

        for (String k : chain) {
            if (numbWithDiffDigits(k)) {
                System.out.println("Число, состоящее из различных цифр: " + k);
                break;
            }
        }
        */


        //           МАТРИЦЫ

        // 8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.

        /*System.out.println("Введите целое число больше 3, нажмите 'Enter'");
        Scanner inputScan = new Scanner(System.in);
        int k = inputScan.nextInt();
        inputScan.close();
        int matrixSize = (int) Math.sqrt(k);
        if (matrixSize*matrixSize < k){
            matrixSize = matrixSize + 1;
        }
        int currElem = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                currElem = i*matrixSize+j+1;
                if (currElem > k) {
                    System.out.print(0 + " ");
                }
                else {
                    System.out.print(currElem + " ");
                }
            }
            System.out.println();
        }
*/
        //9.Ввести с консоли n-размерность матрицы a [n] [n].
        //  Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.

        System.out.println("Введите целое число больше 2 (чтобы указать размерность матрицы), нажмите 'Enter'");
        Scanner inputScan1 = new Scanner(System.in);
        int n = inputScan1.nextInt();
        //inputScan1.close();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) ((Math.random() * (n - (-n) + 1) + (-n)));
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
/*
        // 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.

        int[][] arrRowIncr = new int[n][n];
        copyNbyNmatrix(arr, arrRowIncr);
        //System.out.println(Arrays.deepToString(arrRowIncr));
        System.out.println("Матрица с упорядоченными по возрастанию строками:");
        for (int[] i : arrRowIncr) {
            Arrays.sort(i);
        }
        printMatrix(arrRowIncr);

        int[][] arrColIncr = new int[n][n];
        copyNbyNmatrix(arr, arrColIncr);
        //System.out.println(Arrays.deepToString(arrColIncr));
        System.out.println("Матрица с упорядоченными по возрастанию столбцами:");
        matrixColumnIncrSort(arrColIncr);
        printMatrix(arrColIncr);
*/
/*
        //9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо(влево, вверх, вниз).

        System.out.println("Введите целое число k, на величину которого нужно осуществить сдвиг, нажмите 'Enter'");
        int k = inputScan1.nextInt();
        int shift = (k % arr.length);
        int[][] arrRightShift = new int[n][n];
        copyNbyNmatrix(arr, arrRightShift);
        matrixRightShift(arrRightShift, shift);
        System.out.println("Матрица, сдвинутая вправо на величину k:");
        printMatrix(arrRightShift);

        int[][] arrLeftShift = new int[n][n];
        copyNbyNmatrix(arr, arrLeftShift);
        matrixLeftShift(arrLeftShift, shift);
        System.out.println("Матрица, сдвинутая влево на величину k:");
        printMatrix(arrLeftShift);

        int[][] arrShiftUp = new int[n][n];
        copyNbyNmatrix(arr, arrShiftUp);
        matrixShiftUp(arrShiftUp, shift);
        System.out.println("Матрица, сдвинутая вверх на величину k:");
        printMatrix(arrShiftUp);

        int[][] arrShiftDown = new int[n][n];
        copyNbyNmatrix(arr, arrShiftDown);
        matrixShiftDown(arrShiftDown, shift);
        System.out.println("Матрица, сдвинутая вниз на величину k:");
        printMatrix(arrShiftDown);
*/
 /*
        // 9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд

        maxIncrDecrSequence(arr);
*/
/*
        // 9.4. Найти сумму элементов матрицы, расположенных между первым
        // и вторым положительными элементами каждой строки.

        int count = 0;
        for (int [] x : arr) {
            int sumElemBetw = 0;
            int firstPositiv = -1, secondPositiv = -1;
            for (int j = 0; j < arr.length; j++) {
                if (x[j] >= 0){
                    if (firstPositiv == -1) {
                        firstPositiv = j;
                    } else if (secondPositiv == -1){
                        secondPositiv = j;
                    } else {
                        break;
                    }
                }

                if (firstPositiv != -1 && secondPositiv != -1 && firstPositiv < secondPositiv)
                    for (int k = firstPositiv + 1; k < secondPositiv; k++) {
                        sumElemBetw += x[k];
                    }
            }
            System.out.println("Сумма элементов в " + count + " строке: " + sumElemBetw);
            count++;
        }
*/
/*
        // 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.

        int[][] arrRot90 = new int[n][n];
        copyNbyNmatrix(arr, arrRot90);
        matrixRot90(arrRot90);
        System.out.println("Матрицы, повернутая на 90 градусов против часовой стрелки");
        printMatrix(arrRot90);

        int[][] arrRot180 = new int[n][n];
        copyNbyNmatrix(arrRot90, arrRot180);
        matrixRot90(arrRot180);
        System.out.println("Матрицы, повернутая на 180 градусов против часовой стрелки");
        printMatrix(arrRot180);

        int[][] arrRot270 = new int[n][n];
        copyNbyNmatrix(arrRot180, arrRot270);
        matrixRot90(arrRot270);
        System.out.println("Матрицы, повернутая на 180 градусов против часовой стрелки");
        printMatrix(arrRot270);
*/
 /*
        // 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.

        double[][] arrMinusAvrg = new double[n][n];
        double avrgVal = avrgValueOfMatrix(arr);
        System.out.println("Srednee znachenie " + avrgVal);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrMinusAvrg[i][j] = arr[i][j] - avrgVal;
            }
        }
        System.out.println("Исходная матрица за вычетом ее среднего значения из каждого элемента");
        printMatrix(arrMinusAvrg);
  */

        // 9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.


        // 9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю,
        //      располагались после всех остальных

        int[][] arrZeroAtEnd = new int[n][n];
        copyNbyNmatrix(arr, arrZeroAtEnd);
        zeroAtEnd(arrZeroAtEnd);
        System.out.println("Матрица с нулями, перемещенными в конец строки:");
        printMatrix(arrZeroAtEnd);

    }

    private static void zeroAtEnd(int[][] arr) {
        for (int[] x : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (x[j] == 0) {
                    for (int k = j; k < arr.length - 1; k++) {
                        x[k] = x[k + 1];
                    }
                    x[arr.length - 1] = 0;
                }
            }
        }
    }
}
