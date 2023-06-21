import java.util.Arrays;

class Machine{
    Rotor left;
    Rotor middle;
    Rotor right;
    Rotor ref;
    Machine(Rotor left, Rotor middle, Rotor right, Rotor ref){
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.ref = ref;
    }

    Machine updateMachine(Rotor left, Rotor middle, Rotor right, Rotor ref){
        return new Machine(left, middle, right, ref);
    }

    int map(int input, Rotor r, boolean left){
        if(left){
            int rotor_right = r.findPairAtIndex(input).getValue(); // return the value at int input
            return r.locateKey(rotor_right); // find the letter on the left side of the rotor and return its index
        }else{
            int rotor_left = r.findPairAtIndex(input).getKey(); // return the key at int input
            return r.locateValue(rotor_left); // find the letter on the left side of the rotor and return its index
        }
    }

    int reflect(int x){
        int reflector_right = ref.findPairAtIndex(x).getValue();
        int reflector_left = ref.findPairAtIndex(reflector_right).getKey();
        return ref.locateKey(reflector_left);
    }

    void setStartPosition(int y, Rotor r){
        while(r.findPairAtIndex(0).getKey() != y) {
            r.rotate();
        }
    }

    int encryptOneLetter(int input){
        if(right.findPairAtIndex(0).getKey() == right.stepping_key){
            middle.rotate();
        }
        if(middle.findPairAtIndex(0).getKey() == middle.stepping_key){
            middle.rotate();
            left.rotate();
        }
        right.rotate();

        int l1 = map(input, right, true);
        int l2 = map(l1, middle, true);
        int l3 = map(l2, left, true);
        int re = reflect(l3);
        int r1 = map(re, left, false);
        int r2 = map(r1, middle, false);
        int r3 = map(r2, right, false);
//        System.out.println(" l1: " +l1 + " l2: " + l2 + " l3: " + l3 + " re: " + re + " r1: " + r1 + " r2: " + r2 + " r3: " + r3);
//        System.out.println(r3);
        return r3;
    }

    String encryptUserInput(String in){
        Translate t = new Translate(in);
        int[] machineLanguage = t.translateToMachine();
        int[] machineOut = new int[machineLanguage.length];
        for(int i = 0; i < machineLanguage.length; i++){
            machineOut[i] = encryptOneLetter(machineLanguage[i]);
        }
        String out = t.translateToHuman(machineOut);
        return out;
    }

}

class Rotor {
    Pair[] r;
    int stepping_key;
    Pair[] rOriginal;
    int id;
    Rotor(Pair[] r, int stepping_key, int id){
        this.r = r;
        this.stepping_key = stepping_key;
        rOriginal = r;
        this.id = id;
    }

    void rotate(){
        Pair[] output = new Pair[26];
        for (int i = 0; i < 26; i++){
            output[i] = r[(i+1)%26];
        }
        r = output;
    }

    void reset(){
        r = rOriginal;
        }

    Pair findPairAtIndex(int x){
        // given int x return the pair of letters at that location in the rotor
        return r[x];
    }

    int locateKey(int x){
        // given an int x find its index on the left side of the rotor
        int output = -2;
        for(int i = 0; i < 26; i++){
            if(r[i].getKey() == x){
                output = i;
                return output;
            }
        }
        return output;
    }

    int locateValue(int x){
        // given an int x find its index on the right side of the rotor
        int output = -2;
        for(int i = 0; i < 26; i++){
            if(r[i].getValue() == x){
                output = i;
                return output;
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.r);
    }
}

class Pair{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

    int getKey(){
        return key;
    }

    int getValue(){
        return value;
    }
}

class Translate {
    String userInput;
    Translate(String userInput){
        this.userInput = userInput;
    }

    int[] translateToMachine(){
        userInput = userInput.toUpperCase();
        int[] output = new int[userInput.length()];
        for (int i = 0; i < userInput.length(); i++){
            output[i] = ((int) userInput.charAt(i)) % 65;
        }
        return output;
    }

    String translateToHuman(int[] machineIn){
        StringBuilder output = new StringBuilder(machineIn.length);
        for (int j : machineIn) {
            output.append((char) (j + 65));
        }
        return output.toString();
    }
}

class PlugBoard{
    Rotor board;
    PlugBoard(Rotor board){
        this.board = board;
    }
}


public class Main {
    static Pair[] rotor1 = {new Pair(0, 4), new Pair(1, 10), new Pair(2, 12), new Pair(3, 5), new Pair(4, 11), new Pair(5, 6), new Pair(6, 3), new Pair(7, 16), new Pair(8, 21), new Pair(9, 25), new Pair(10, 13), new Pair(11, 19), new Pair(12, 14), new Pair(13, 22), new Pair(14, 24), new Pair(15, 7), new Pair(16, 23), new Pair(17, 20), new Pair(18, 18), new Pair(19, 15), new Pair(20, 0), new Pair(21, 8), new Pair(22, 1), new Pair(23, 17), new Pair(24, 2), new Pair(25, 9)};
    static Pair[] rotor2 = {new Pair(0, 0), new Pair(1, 9), new Pair(2, 3), new Pair(3, 10), new Pair(4, 18), new Pair(5, 8), new Pair(6, 17), new Pair(7, 20), new Pair(8, 23), new Pair(9, 1), new Pair(10, 11), new Pair(11, 7), new Pair(12, 22), new Pair(13, 19), new Pair(14, 12), new Pair(15, 2), new Pair(16, 16), new Pair(17, 6), new Pair(18, 25), new Pair(19, 13), new Pair(20, 15), new Pair(21, 24), new Pair(22, 5), new Pair(23, 21), new Pair(24, 14), new Pair(25, 4)};
    static Pair[] rotor3 = {new Pair(0, 1), new Pair(1, 3), new Pair(2, 5), new Pair(3, 7), new Pair(4, 9), new Pair(5, 11), new Pair(6, 2), new Pair(7, 15), new Pair(8, 17), new Pair(9, 19), new Pair(10, 23), new Pair(11, 21), new Pair(12, 25), new Pair(13, 13), new Pair(14, 24), new Pair(15, 4), new Pair(16, 8), new Pair(17, 22), new Pair(18, 6), new Pair(19, 0), new Pair(20, 10), new Pair(21, 12), new Pair(22, 20), new Pair(23, 18), new Pair(24, 16), new Pair(25, 14)};
    static Pair[] rotor4 = {new Pair(0, 4), new Pair(1, 18), new Pair(2, 14), new Pair(3, 21), new Pair(4, 15), new Pair(5, 25), new Pair(6, 9), new Pair(7, 0), new Pair(8, 24), new Pair(9, 16), new Pair(10, 20), new Pair(11, 8), new Pair(12, 17), new Pair(13, 7), new Pair(14, 23), new Pair(15, 11), new Pair(16, 13), new Pair(17, 5), new Pair(18, 19), new Pair(19, 6), new Pair(20, 10), new Pair(21, 3), new Pair(22, 2), new Pair(23, 12), new Pair(24, 22), new Pair(25, 1)};
    static Pair[] rotor5 = {new Pair(0, 21), new Pair(1, 25), new Pair(2, 1), new Pair(3, 17), new Pair(4, 6), new Pair(5, 8), new Pair(6, 19), new Pair(7, 24), new Pair(8, 20), new Pair(9, 15), new Pair(10, 18), new Pair(11, 3), new Pair(12, 13), new Pair(13, 7), new Pair(14, 11), new Pair(15, 23), new Pair(16, 0), new Pair(17, 22), new Pair(18, 12), new Pair(19, 9), new Pair(20, 16), new Pair(21, 14), new Pair(22, 5), new Pair(23, 4), new Pair(24, 2), new Pair(25, 10)};
    static Pair[] ref_B  = {new Pair(0, 24), new Pair(1, 17), new Pair(2, 20), new Pair(3, 7), new Pair(4, 16), new Pair(5, 18), new Pair(6, 11), new Pair(7, 3), new Pair(8, 15), new Pair(9, 23), new Pair(10, 13), new Pair(11, 6), new Pair(12, 14), new Pair(13, 10), new Pair(14, 12), new Pair(15, 8), new Pair(16, 4), new Pair(17, 1), new Pair(18, 5), new Pair(19, 25), new Pair(20, 2), new Pair(21, 22), new Pair(22, 21), new Pair(23, 9), new Pair(24, 0), new Pair(25, 19)};
    static Pair[] ref_C  = {new Pair(0, 5), new Pair(1, 21), new Pair(2, 15), new Pair(3, 9), new Pair(4, 8), new Pair(5, 0), new Pair(6, 14), new Pair(7, 24), new Pair(8, 4), new Pair(9, 3), new Pair(10, 17), new Pair(11, 25), new Pair(12, 23), new Pair(13, 22), new Pair(14, 6), new Pair(15, 2), new Pair(16, 19), new Pair(17, 10), new Pair(18, 20), new Pair(19, 16), new Pair(20, 18), new Pair(21, 1), new Pair(22, 13), new Pair(23, 12), new Pair(24, 7), new Pair(25, 11)};

    static int step1 = 16; // Q
    static int step2 = 4; // E
    static int step3 = 21; // V
    static int step4 = 9; // J
    static int step5 = 26; // Z

    static int id1 = 0;
    static int id2 = 1;
    static int id3 = 2;
    static int id4 = 3;
    static int id5 = 4;
    static int idB = 0;
    static int idC = 1;
    static Rotor r1_left = new Rotor(rotor1, step1, id1);
    static Rotor r1_middle = new Rotor(rotor1, step1, id1);
    static Rotor r1_right = new Rotor(rotor1, step1, id1);
    static Rotor r2_left = new Rotor(rotor2, step2, id2);
    static Rotor r2_middle = new Rotor(rotor2, step2, id2);
    static Rotor r2_right = new Rotor(rotor2, step2, id2);
    static Rotor r3_left = new Rotor(rotor3, step3, id3);
    static Rotor r3_middle = new Rotor(rotor3, step3, id3);
    static Rotor r3_right = new Rotor(rotor3, step3, id3);
    static Rotor r4_left = new Rotor(rotor4, step4, id4);
    static Rotor r4_middle = new Rotor(rotor4, step4, id4);
    static Rotor r4_right = new Rotor(rotor4, step4, id4);
    static Rotor r5_left = new Rotor(rotor5, step5, id5);
    static Rotor r5_middle = new Rotor(rotor5, step5, id5);
    static Rotor r5_right = new Rotor(rotor5, step5, id5);
    static Rotor refB = new Rotor(ref_B, step1, idB);
    static Rotor refC = new Rotor(ref_C, step1, idC);
    public static Rotor[] allRotorsLeft = new Rotor[]{r1_left, r2_left, r3_left, r4_left, r5_left};
    public static Rotor[] allRotorsMiddle = new Rotor[]{r1_middle, r2_middle, r3_middle, r4_middle, r5_middle};
    public static Rotor[] allRotorsRight = new Rotor[]{r1_right, r2_right, r3_right, r4_right, r5_right};
    public static Rotor[] allPossibleReflectors = new Rotor[]{refB, refC};
//    public static Machine m = new Machine(Main.r1, Main.r2, Main.r3, Main.ref);

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);

    }
}
