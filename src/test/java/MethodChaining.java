public class MethodChaining {

    // common syntax for invoking multiple method calls

    public static void main(String[] args) {

        String name = "Pav";

//        name = name.concat(" is writing code");
//        name = name.toUpperCase();
//        name = name.trim();

        //can be condensed like this:

        name = name.concat(" is writing code ")
                   .toUpperCase();


        System.out.println(name);
    }
}
