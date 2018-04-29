package Game;

import Characters.Creatures.Creature;
import Characters.Heroes.*;
import Characters.Heroes.Fighters.Dwarf;
import Characters.Heroes.Fighters.Knight;
import Characters.Heroes.Fighters.Barbarian;
import Characters.Heroes.Healers.Cleric;
import Characters.Heroes.Hero;
import Characters.Heroes.Mages.Spell;
import Characters.Heroes.Mages.Warlock;
import Characters.Narrator;
import Room.Room;

import java.util.ArrayList;

public class Game {


    private String name;
    private int roomsToGenerate;
    private ArrayList<Room> newRooms;
    private ArrayList<Room> completedRooms;
    private ArrayList<Hero> heroes;


    public Game(String name, int roomsToGenerate){

        this.name = name;
        this.roomsToGenerate = roomsToGenerate;
        this.heroes = new ArrayList<>();

        ArrayList<Room> generatedRooms = new ArrayList<>();
        for (int i = 0; i < roomsToGenerate ; i++) {
            generatedRooms.add(new Room());
        }
        this.newRooms = generatedRooms;
        this.completedRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Room> getNewRooms() {
        return newRooms;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addKnight(String name){
        heroes.add(new Knight(name));
    }

    public void addDwarf(String name){
        heroes.add(new Dwarf(name));
    }

    public void addBarbarian(String name){
        heroes.add(new Barbarian(name));
    }

    public void addCleric(String name){
        heroes.add(new Cleric(name));
    }

    public void addWarlock(String name){
        heroes.add(new Warlock(name));
    }

    public void addHeroesToFirstRoom(){
        ArrayList<Hero> heroesInHallway = new ArrayList<>();
        int heroCount = heroes.size();
        for (int i = 0; i < heroCount ; i++) {
            heroesInHallway.add(heroes.remove(0));}
            newRooms.get(0).addHeroesFromHallway(heroesInHallway);
        }

    public ArrayList<Room> getCompletedRooms() {
        return completedRooms;
    }

    public void returnHeroesFromRoomToHallway(){
        ArrayList<Hero> heroesInRoom = this.getNewRooms().get(0).getHeroes();
        ArrayList<Hero> heroesAlive = new ArrayList<>();
        int heroCount = heroesInRoom.size();
        for (int i = 0; i < heroCount ; i++) {
            if(heroesInRoom.get(0).getHp() > 0){
            heroesAlive.add(heroesInRoom.remove(0));}}
        for (Hero h: heroesAlive){ heroes.add(h);}
    }

    public void moveCompletedRoomtoCompletedArrayList(){
        ArrayList<Room> tempHolding  = new ArrayList<>();
        tempHolding.add(newRooms.remove(0));
        completedRooms.add(tempHolding.get(0));
    }

    public void moveToNextRoom(){
        returnHeroesFromRoomToHallway();
        moveCompletedRoomtoCompletedArrayList();
        addHeroesToFirstRoom();
    }

}
