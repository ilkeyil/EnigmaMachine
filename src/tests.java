import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class tests {

    String in = "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG";
    @Test
    public void testEncrypt1() {
        String expected1 = "HNXATRPAVKHORPCYBFKRAZPMYQLMKVZKKJIZWIKMPWRPRYSLMYFKXORJZPOQCAVIVUMSYOSJCRVUOOP";
        Machine m1 = new Machine(Main.r1_left, Main.r1_middle, Main.r1_right, Main.refB);
        String humanLang1 = m1.encryptUserInput(in);
        Assertions.assertEquals(humanLang1, expected1);
    }

    @Test
    public void testEncrypt2() {
        String expected2 = "VYSWPJSARVTHWVPRANQKCKYSQNDZYOJJXDMYLSLKDLZNDRSZFPCIPKDNYXZNQJOFLKNFUANOEIJMUIL";
        Machine m2 = new Machine(Main.r2_left, Main.r2_middle, Main.r2_right, Main.refB);
        String humanLang2 = m2.encryptUserInput(in);
        Assertions.assertEquals(humanLang2, expected2);
    }

    @Test
    public void testEncrypt3() {
        String expected3 = "XWIAFZZLYYUPHZRHJUTDIYYRLNTTLPOAQTDHXXUPSYNXLFRJITNDEDOSJLZSYBTWIRQTNJTXADHLFQK";
        Machine m3 = new Machine(Main.r1_left, Main.r2_middle, Main.r3_right, Main.refB);
        String humanLang3 = m3.encryptUserInput(in);
        Assertions.assertEquals(humanLang3, expected3);
    }

    @Test
    public void testEncrypt4() {
        String expected4 = "PPOSJLBSEDZORMTPRTRWYSONYERCIUFRZLYMFEACESUOTKABXEOLMBOSJLHSWNMBXWIAOBSIOONCAOR";
        Machine m4 = new Machine(Main.r3_left, Main.r3_middle, Main.r3_right, Main.refB);
        String humanLang4 = m4.encryptUserInput(in);
        Assertions.assertEquals(humanLang4, expected4);
    }

    @Test
    public void testEncrypt5() {
        String expected5 = "NXEUXNUQHPQHTZTMWPVMISJBZCSBOBTRTTPSYQIBQTXLBRRSOVQEBDTKBULEAUUTNMRRFQKZZVLOJBY";
        Machine m5 = new Machine(Main.r1_left, Main.r2_middle, Main.r4_right, Main.refB);
        String humanLang5 = m5.encryptUserInput(in);
        Assertions.assertEquals(humanLang5, expected5);
    }

    @Test
    public void testEncrypt6() {
        String expected6 = "JVUZRYYCIFAIDSSBHDZXUNUUHLKJIFFFHLWIYHVHZLAHSCXBLDJKBSYYXXPIUSNFWWTZDVPQZKBULIR";
        Machine m6 = new Machine(Main.r1_left, Main.r2_middle, Main.r3_right, Main.refC);
        String humanLang6 = m6.encryptUserInput(in);
        Assertions.assertEquals(humanLang6, expected6);
    }

    @Test
    public void testEncrypt7() {
        String expected7 = "QJAQPIWZRCIFRWPRXSRYUPCOXNLWNZAVUWIZFLCWLMFDTRUWYIRQIVSYZOJVVZEKQQITYJJQIWNLZCV";
        Machine m7 = new Machine(Main.r5_left, Main.r5_middle, Main.r5_right, Main.refB);
        String humanLang7 = m7.encryptUserInput(in);
        Assertions.assertEquals(humanLang7, expected7);
    }
    @Test
    public void testEncrypt8() {
        String expected8 = "IDFYIDSXVFVXIERJWUDANNVVFRWRDVPBYOAHIARWMVNLJOUANLYAOMWVEEHSANJIMDPNRCRZFRPSEVE";
        Machine m8 = new Machine(Main.r1_left, Main.r1_middle, Main.r5_right, Main.refB);
        String humanLang8 = m8.encryptUserInput(in);
        Assertions.assertEquals(humanLang8, expected8);
    }
    @Test
    public void testEncrypt9() {
        String expected9 = "BIVOLSQNUOLHVONAPVPUAAIUYDLPNTJWTVKUVEYTTSTQZTEEMVZJJLSUBZYMEUEAYMRDYKBONZNEUAJ";
        Machine m9 = new Machine(Main.r2_left, Main.r2_middle, Main.r5_right, Main.refB);
        String humanLang9 = m9.encryptUserInput(in);
        Assertions.assertEquals(humanLang9, expected9);
    }
    @Test
    public void testEncrypt10() {
        String expected10 = "STXIJQWEBSMFIFCSXSAAEFCCNCMVFROYOVXJTUNQHJAMDSLXVKZWXTXUBKKZECBQTNMEBLFJQNAAVFI";
        Machine m10 = new Machine(Main.r1_left, Main.r3_middle, Main.r5_right, Main.refC);
        String humanLang10 = m10.encryptUserInput(in);
        Assertions.assertEquals(humanLang10, expected10);
    }

}