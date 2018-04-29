package Characters.Heroes.Mages;

import Characters.Creatures.Creature;
import Characters.Creatures.CreatureType;
import Characters.Character;
import Characters.Heroes.Hero;

public abstract class Mage extends Hero {

    private Spell spell;
    private Creature creature;

    public Mage(String name){
        super(name, "Attacker");
        this.spell = Spell.getRandomSpell();
        this.creature = new Creature(CreatureType.getRandomCreature());
        //Massive problem still with this random element for newing up objects. Need to fix.

    }

    public Creature getCreature(){
        return this.creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    //move 1. This is the move to use the spell that the Mage has assigned to them.
    public String standardMove(Character characterToAttack){
        if(shouldDoMove(this.spell.getChanceValue())){
            characterToAttack.takeDamage(this.spell.getDamageValue());
            return (this.getName() + " attacked " + characterToAttack.getName() + " successfully.");
        }
        return this.getName() + " missed!";
    }


}
