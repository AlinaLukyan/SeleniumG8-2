package lesson3;


public class Terminator extends Robot{

    public Terminator(String name){
        super.name = name;
    }

    public int generateDamage(){
        return randomNumber.nextInt(12 - 8 + 1) + 8;
    }

}
