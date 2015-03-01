package lesson3;

import java.util.Random;

public class Main {

    public static void main(String []args) {

        Squeezer squeezer = new Squeezer("Squeezer");
        Terminator terminator = new Terminator("Terminator");
        SqueezersMaster squeezersMaster = new SqueezersMaster();


        Fight firstFight = new Fight(squeezer, terminator);
        Fight secondFight = new Fight(terminator, squeezer);

        Thread first = new Thread(firstFight);
        Thread second = new Thread(secondFight);

        first.start();
        second.start();

        //terminator.forceOutOfTheRing(squeezer);

        //squeezersMaster.repairOwnRobot(squeezer);

    }

    private static class Fight implements Runnable {
        private Robot robot;
        private Robot victim;

        public Fight(Robot robot, Robot victim) {
            this.robot = robot;
            this.victim = victim;
        }

        @Override
        public void run() {
            while(robot.isAlive()) {
                robot.fight(victim);
                if (!victim.isAlive()) return;
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
