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
    private ArrayList<Room> rooms;
    private ArrayList<Hero> heroes;
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;

    public Game(String name, int roomsToGenerate){

        this.name = name;
        this.roomsToGenerate = roomsToGenerate;
        this.heroes = new ArrayList<>();

        ArrayList<Room> generatedRooms = new ArrayList<>();
        for (int i = 0; i < roomsToGenerate ; i++) {
            generatedRooms.add(new Room());
        }
        this.rooms = generatedRooms;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
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

    public void addWarlock(String name, Spell spell, Creature creature){
        heroes.add(new Warlock(name, spell, creature));
    }

    public void addHeroesToFirstRoom(){
        ArrayList<Hero> heroesInHallway = new ArrayList<>();
        int heroCount = heroes.size();
        for (int i = 0; i < heroCount ; i++) {
            heroesInHallway.add(heroes.remove(0));}
            rooms.get(0).addHeroesFromHallway(heroesInHallway);
        }
}
