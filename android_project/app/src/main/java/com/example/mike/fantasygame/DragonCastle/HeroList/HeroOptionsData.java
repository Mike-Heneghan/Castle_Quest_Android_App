package com.example.mike.fantasygame.DragonCastle.HeroList;

import java.util.ArrayList;

public class HeroOptionsData {

    ArrayList<HeroOption> list;

    public HeroOptionsData(){
        list = new ArrayList<>();
        list.add(0, new HeroOption(1, "Knight", "The Knight wields a strong shield which reduces the damage suffered by 50%.", "HP: 100", "The Knight attacks accurately with a sword.", "At close counters the Knight can't miss stabbing an opponent with a concealed dagger."));
        list.add(1, new HeroOption(2, "Dwarf", "The Dwarf dons armour shield which reduces the damage they suffer by 25%.", "HP: 100", "The Dwarf swings a mighty axe which inflicts high damage.", "Dwarves always carry 5 Throwing axes, use them wisely."));
       list.add(2, new HeroOption(3, "Barbarian", "All barbarians wear arm guards to reduce damage they receive by 10% without slowing them down.", "HP: 100", "The Barbarian wields a powerful but accurate club.", "When enraged the Barbarian can go into a fury that allows them to feel no pain and kill their opponent at the cost of their own life especially when health is low."));
        list.add(3, new HeroOption(4, "Warlock", "The Warlock is trained in magic and can cast powerful spells as well as taming wild creatures to their will.", "HP: 100", "The Warlock attacks their enemy with a powerful spell.", "The Warlock's tamed creature attacks with all their might often missing but immensely powerful when successful"));
        list.add(4, new HeroOption(5, "Cleric", "The Cleric is a pacifist who has sworn an oath to cause no harm but help the just.", "HP: 100", "The Cleric heals the hero in most need.", "The Cleric can defy his holy orders and try to resurrect the dead or heal an ally beyond their natural levels."));
    }

    public ArrayList<HeroOption> getList() {
        return list;
    }
}
