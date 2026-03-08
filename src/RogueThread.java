public class RogueThread implements Runnable {

    public void run() {
        Util util = new Util();

        while (true) {
            util.sleepRandomTime("RogueThread");
            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null) {
                MerkleManager.iStrikes++;
                System.out.println("Rogue grabbed: " + sNewWord + " -- STRIKE!!");
            }
        }

    }
}
