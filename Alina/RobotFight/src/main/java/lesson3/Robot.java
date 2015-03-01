package lesson3;

import java.util.Random;

public abstract class Robot {

    protected Random randomNumber = new Random();

    protected int healthPoint;
    protected boolean outOfTheRing = false;
    protected String name;

    public Robot(){
        healthPoint = 100;
    }

    public abstract int generateDamage();

    public void reduceHealth(int damage) {
        healthPoint -= damage;
    }

    public void fight(Robot obj) {
        obj.reduceHealth(obj.generateDamage());
        System.out.println(obj.toString());
    }


//    public <U extends Robot> void fight(U object) {
//        object.reduceHealth(object.generateDamage());
//
//        if(object.healthPoint < 0) {
//            System.out.println("You're dead, man");
//            object.healthPoint = 0;
//        }
//    }

    public void forceOutOfTheRing(Robot obj){
        if(obj.healthPoint < 15){
            if(obj.getRandomBoolean()){
                System.out.println("The game is over for " + obj.getClass().getCanonicalName());
                obj.outOfTheRing = true;
            } else {
                System.out.println("Try again");
            }
        } else {
            System.out.println("You can't force me to the hole. I'm strong enough! ");
        }
    }


    public boolean getRandomBoolean(){
        return randomNumber.nextBoolean();
    }

    public boolean isAlive() {
        if(healthPoint > 0) return true;
        healthPoint = 0;
        System.out.println("I'm " + name + ", and I'm dead :(");
        return false;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", healthPoint=" + healthPoint +
                '}';
    }
}
