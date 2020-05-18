import org.testng.annotations.Test;

public class FirstClass {

    @Test
    public void test00001() {
        System.out.println("This will be printed");
    }

    @Test
    public void test0002() {
        int myNumber = 5;

        System.out.println(myNumber);
    }


    @Test
    public void test0003() {

        String messageOne = new String("Who let the dogs out?");

        String messageTwo = "Who who who who!";

        String completeMessage = messageOne + messageTwo;

        System.out.println(completeMessage);
    }

    @Test
    public void test004() {
        int num = 5;
        String message = "I have " + num + " cookies";

        System.out.println(message);
    }

    @Test
    public void test005() {
        boolean toBe = false;

        boolean b = toBe || !toBe;
        if (b) {
            System.out.println(toBe);
        }

        int children = 0;


        int a = 0;
        b = true;
        boolean c = false;
        //The following line will give an error
        System.out.println(a);
    }

    //TODO: change to accept parameters so it will always print correct message
    @Test
    public void test006() {
        int a = 5;

        if (a == 4) {
            System.out.println("Ohhh! So a is 4!");
        } else {
            System.out.println("A IS NOT EQUAL TO 4, it is " + a);
        }
    }

    @Test
    public void test007() {
        int[] arrayOfIntegers = {1, 9, 9, 5};

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            int currentElement = arrayOfIntegers[i];
            System.out.println(currentElement);
        }
    }

    @Test
    public void test008() {
        int[] myFirstArray = new int[100];
        for (int i = 0; i < myFirstArray.length; i++) {
            System.out.println(myFirstArray[i]);
        }

    }


    @Test
    public void test3() {

        int a = 5;
        boolean b = a == 4;
        if (b) ;
        System.out.println("check the function");
    }

    @Test
    public void test7() {

        int[] arr = {2, 0, 1, 3, 10, 7, 19};
        for (int el : arr) {
            System.out.println(el);
        }
    }


    @Test
    public void test8() {

        int i;
        for (i = 0; i < 5; i++) {
            if (i >= 2) {
                break;
            }
            System.out.println("Yuhu");
        }
        System.out.println(i);
    }

    @Test
    public void test10() {
        int[] arrayofintegers = {1, 9, 9, 5};
        printAllMembersOfAray(arrayofintegers);
        }

    private void printAllMembersOfAray(int[] arrayofintegers) {
        for (int i = 0; i <= arrayofintegers.length; i++) {
            System.out.println(arrayofintegers[i]);
    }

}


    @Test
    public void test_swapNumbers() {
        int[] input = {1,2,3,4,5,6};
        int indexL = 0 ;
        int indexR = 1;

        swap(input, indexL, indexR);

    }

    private void swap(int[] input, int indexL, int indexR) {
        int tempElement = 0;
        if (indexL => 0 && indexL < input.length && indexR > 0 && indexR < input.length){
            tempElement = input[indexL];
            input[indexL] = input[indexR];
            input[indexR] = tempElement ;
        }
    }

}
