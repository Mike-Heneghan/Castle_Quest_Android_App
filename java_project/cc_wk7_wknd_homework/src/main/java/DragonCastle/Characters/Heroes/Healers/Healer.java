package DragonCastle.Characters.Heroes.Healers;

import DragonCastle.Characters.Character;
import DragonCastle.Characters.Heroes.Hero;

public abstract class Healer extends Hero {

    private HealingTool healingTool;

    public Healer(String name){
        super(name, "Healer");
        this.healingTool = HealingTool.getRandomHealingTool();
//
//
// So this is bad code - I dont know why but the tests are failing randomly. I would have thought that the randomhealingtool would run once and store the one healing tool but it seems to be running the method every time I do anything with the cleric so they have a constantly evolving tool...
//
//        this.healingTool = HealingTool.AGOODSNOOZE;
    }

    public HealingTool getHealingTool() {
        return healingTool;
    }

    public void setHealingTool(HealingTool healingTool) {
        this.healingTool = healingTool;
    }


    //move1. This move uses whatever healingTool the healer is in ownership of.
    public String standardMove(Character characterToHeal){
        if(shouldDoMove(this.healingTool.chanceValue))
        { characterToHeal.beHealed(this.healingTool.healingValue);
        return (this.getName() + " healed " + characterToHeal.getName() + " successfully.");
        }
        return this.getName() + " missed " + characterToHeal.getName() + "!";
    }

    //move2. This move resurrects the player with 100 hp, but the likelihood of it happening is low as the chance value is 2.
    public String signatureMove(Character characterToHeal){
        if(shouldDoMove(HealingTool.RESURRECTION.chanceValue)){
            characterToHeal.beHealed(HealingTool.RESURRECTION.healingValue);
            return this.getName() + " healed " + characterToHeal.getName() + " successfully.";
        }
        return this.getName() + " missed " + characterToHeal.getName() + "!";
    }


    public void randomHealingTool() {
        int result = getRandomNumber(4);
        if (result == 0) {
            this.healingTool = HealingTool.HERBS;
        } else if (result == 1) {
            this.healingTool = HealingTool.BITTEROOT;
        }else if (result == 2) {
            this.healingTool = HealingTool.AGOODSNOOZE;
        }else if (result == 3) {
            this.healingTool = HealingTool.HERBS;
        }
    }



}

