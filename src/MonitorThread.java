public class MonitorThread implements Runnable {
    public void run() {
        Util util = new Util();

        while (true) {
            if (MerkleManager.sMerkleRoot != null) {
                if (MerkleManager.sMerkleRoot.equals(MerkleManager.sExpectedRoot)) {
                    System.out.println("Yippie YOU WON: " + MerkleManager.sMerkleRoot);
                    System.out.println("-Exiting Game-");
                    System.exit(0);
                } else {
                    System.out.println("Merkle root mismatch -- LOSER!");
                    System.out.println("-Exiting Game-");
                    System.exit(0);
                }
            } else if (MerkleManager.iStrikes >= 3) {
                System.out.println("Three Strikes, You're out!");
                System.out.println("-Exiting Game-");
                System.exit(0);
            }
            util.sleep(1);
        }
    }
    }