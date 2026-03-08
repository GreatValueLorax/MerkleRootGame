public class MerkleManager {

    public static volatile String sUserWord;
    public static String sExpectedRoot;
    public static String sMerkleRoot = null;
    public static int iStrikes = 0;

    public void manage(){
        Util util = new Util();

        sExpectedRoot = util.promptUser("enter expected Merkle Root:");


        MerkleThread mt = new MerkleThread();
        RogueThread rt = new RogueThread();
        MonitorThread mot = new MonitorThread();

        Thread oThread1 = new Thread(mt);
        Thread oThread2 = new Thread(rt);
        Thread oThread3 = new Thread(mot);

        oThread1.start();
        oThread2.start();
        oThread3.start();

        while (true) {
            String word = util.promptUser("Enter a word:");
            sUserWord = word;
            System.out.println("Your guess: " + word);
        }
        }
        public static synchronized String grabWord() {
        String temp = sUserWord;
        sUserWord = null;
        return temp;
    }
}

