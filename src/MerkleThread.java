import java.util.ArrayList;

public class MerkleThread implements Runnable {
    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;

    public void run() {
        Util oUtil = new Util();
        lstWords = new ArrayList<>();
        lstWords.add("t1");
        lstWords.add("t2");
        lstWords.add("t3");
        lstWords.add("t4");

        while (true) {
            oUtil.sleepRandomTime("MerkleThread");
            String sNewWord = MerkleManager.grabWord();

            if(sNewWord != null) {
                System.out.println("Merkle GET!: " + sNewWord);
                lstWords.add(sNewWord);

                if (lstWords.size() == iMerkleTreeInputs) {
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(lstWords);
                }
                }
            }

    }
}