package be.cegeka.battle;

import com.sun.org.apache.xpath.internal.axes.AxesWalker;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void getWeapon_returnsBareFist() throws Exception {
        Soldier soldier = new Soldier("vandamme");

        assertThat(soldier.getWeapon()).isInstanceOf(BareFist.class);
    }

    @Test
    public void setWeapon_givenSword_soldierWeaponIsSword() throws Exception {
        Soldier soldier = new Soldier("vandamme");

        soldier.setWeapon(new Sword());
        assertThat(soldier.getWeapon()).isInstanceOf(Sword.class);
    }

    @Test
    public void attack_ifSoldierWithBareFist_attackSoldierWithSameWeaponAttackerWins(){
        Soldier attacker = new Soldier("attacker");
        Soldier defender = new Soldier("defender");

        Soldier winner = attacker.attack(defender);

        assertThat(winner).isEqualTo(attacker);
    }

    @Test
    public void attack_ifSoldierWithBareFist_attackSoldierWithLessPowerfullWeaponAttackerWins(){
        Soldier attacker = new Soldier("attacker");
        attacker.setWeapon(new Axe());
        Soldier defender = new Soldier("defender");
        defender.setWeapon(new Spear());

        Soldier winner = attacker.attack(defender);

        assertThat(winner).isEqualTo(attacker);
    }

    @Test
    public void attack_ifSoldierWithBareFist_attackSoldierWithMorePowerfullWeaponDefenderWins(){
        Soldier attacker = new Soldier("attacker");
        Soldier defender = new Soldier("defender");
        defender.setWeapon(new Sword());

        Soldier winner = attacker.attack(defender);

        assertThat(winner).isEqualTo(defender);
    }

    @Test
    public void name() throws Exception {
    }
}