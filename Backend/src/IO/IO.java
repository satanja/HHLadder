package IO;

import Main.Main;
import Weapon.*;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class IO {

    private Main main;

    private Scanner in;

    public IO(Main main) {
        this.main = main;
        in = new Scanner(System.in);
    }

    public void read() {
        String command = in.next();
        switch (command) {
            case "add":
                readAdd();
                break;
            case "match":
                readMatch();
                break;
            case "print":
                readPrint();
                break;
            case "exit":
                return;
        }
        read();
    }

    private Weapon readWeapon() throws IllegalArgumentException {
        String weapon = in.next();
        WeaponCreator creator = new WeaponCreator();
        return creator.createWeapon(weapon);
    }

    private void readAdd() {
        Weapon weapon = readWeapon();
        String name = in.next();
        main.addFencer(weapon, name);
    }

    private void readMatch() {
        Weapon weapon = readWeapon();
        String nameA = in.next();
        String nameB = in.next();
        int scoreA = in.nextInt();
        int scoreB = in.nextInt();
        main.processMatch(weapon, nameA, nameB, scoreA, scoreB);
    }

    private void readPrint() {
        String flag = in.next();
        switch (flag) {
            case "-a":
                // TODO implement
                break;
            case "-w":
                Weapon weapon = readWeapon();
                String ladderString = main.ladderToString(weapon);
                System.out.println(ladderString);
                break;
        }
    }
}
