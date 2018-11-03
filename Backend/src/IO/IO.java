package IO;

import Ladder.LadderCreator;
import Main.Main;
import Weapon.*;

import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 * @author S.A. Tanja
 */
public class IO {

    private Main main;

    private Scanner in;

    public IO(Main main) {
        this.main = main;
        in = new Scanner(System.in);
    }

    /**
     * Reads the next command. Supported commands:
     * <ul>
     *     <li><b>add</b> The command to add a fencer to a specific ladder</li>
     *     <li><b>match</b> The command to process a bout between two fencers</li>
     *     <li><b>print</b> The command to print a ladder</li>
     *     <li><b>exit</b> To exit the application</li>
     * </ul>
     */
    public void read() {
        while(true) {
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
        }
    }

    /**
     * Reads the console for the weapon
     * @return The appropriate weapon object
     * @throws IllegalArgumentException If the input string is not a recognized weapon
     */
    private Weapon readWeapon() throws IllegalArgumentException {
        String weapon = in.next();
        WeaponCreator creator = new WeaponCreator();
        return creator.createWeapon(weapon);
    }

    /**
     * Auxiliary method for processing the read command
     */
    private void readAdd() {
        Weapon weapon = readWeapon();
        String name = in.next();
        main.addFencer(weapon, name);
        printLadder(weapon);
    }

    /**
     * Auxiliary method for processing the match command
     */
    private void readMatch() {
        Weapon weapon = readWeapon();
        String nameA = in.next();
        String nameB = in.next();
        int scoreA = in.nextInt();
        int scoreB = in.nextInt();
        main.processMatch(weapon, nameA, nameB, scoreA, scoreB);
        printLadder(weapon);
    }

    /**
     * Auxiliary method for processing the print command
     */
    private void readPrint() {
        String flag = in.next();
        switch (flag) {
            case "-a":
                WeaponCreator creator = new WeaponCreator();
                for (Weapon weapon : creator) {
                    printLadder(weapon);
                }
                break;
            case "-w":
                Weapon weapon = readWeapon();
                printLadder(weapon);
                break;
        }
    }

    private void printLadder(Weapon weapon) {
        String ladderString = main.ladderToString(weapon);
        System.out.println(ladderString);
    }
}
