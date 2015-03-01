package lesson3;


public class Squeezer extends Robot{

    public Squeezer(String name){
        super.name = name;
    }

    public int generateDamage(){
        return randomNumber.nextInt(13 - 7 + 1) + 7;
    }

}
