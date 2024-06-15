import java.util.List;
import java.util.*;
class DnDCharacter {
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int hitPoints;
    int modifierCharacterConstitution;

    public  DnDCharacter() {
        List<Integer> rollStrength = this.rollDice();
        List<Integer> rollDexterity = this.rollDice();
        List<Integer> rollConstitution = this.rollDice();
        List<Integer> rollIntelligence = this.rollDice();
        List<Integer> rollWisdom = this.rollDice();
        List<Integer> rollCharisma = this.rollDice();

        this.strength = this.ability(rollStrength);
        this.dexterity = this.ability(rollDexterity);
        this.constitution = this.ability(rollConstitution);
        this.intelligence = this.ability(rollIntelligence);
        this.wisdom = this.ability(rollWisdom);
        this.charisma = this.ability(rollCharisma);

        // this.strength = this.ability(this.rollDice());
        // this.dexterity = this.ability(this.rollDice());
        // this.constitution = this.ability(this.rollDice());
        // this.intelligence = this.ability(this.rollDice());
        // this.wisdom = this.ability(this.rollDice());
        // this.charisma = this.ability(this.rollDice());

        this.modifierCharacterConstitution = this.modifier(this.constitution);
        this.hitPoints = 10 + this.modifierCharacterConstitution;
    }

    int ability(List<Integer> scores) {
        List<Integer> abilityRoll = new ArrayList<>(scores);
        Collections.sort(abilityRoll);
        return abilityRoll.get(1) + abilityRoll.get(2) + abilityRoll.get(3);      
    }

    List<Integer> rollDice() {
        Random random = new Random();
        List<Integer> rolls = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            rolls.add(random.nextInt(6) + 1);
        }

        return rolls;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10 )/ 2.0);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return this.hitPoints;
            }
}


// La division en Java est sensible au type des opérandes. Lorsque vous divisez deux entiers, Java effectue une division entière, ce qui signifie que le résultat est également un entier, avec la partie décimale tronquée. Par exemple :

// 7 / 2 donne 3 (la partie décimale 0.5 est tronquée)
// -7 / 2 donne -3 (la partie décimale -0.5 est tronquée)
// En revanche, lorsque l'un des opérandes est un nombre à virgule flottante (par exemple, 2.0), Java effectue une division en virgule flottante, conservant la partie décimale :

// 7 / 2.0 donne 3.5
// -7 / 2.0 donne -3.5
// C'est pourquoi, en utilisant 2.0 dans votre fonction, vous obtenez la division correcte en virgule flottante avant d'appliquer Math.floor, ce qui donne le résultat attendu.


// Immutable vs Mutable Lists
// List.of(...)

// En Java, List.of(...) crée une liste immuable, ce qui signifie qu'elle ne peut pas être modifiée après sa création. Toute tentative de modifier une telle liste, comme le tri, génère une UnsupportedOperationException.
// new ArrayList<>()

// En revanche, new ArrayList<>() crée une liste mutable qui peut être modifiée après sa création, ce qui permet des opérations telles que l'ajout, la suppression et le tri des éléments.

