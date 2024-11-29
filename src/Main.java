import javax.sound.midi.Soundbank;

import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Avventura avventura;
        int nStanze = 5;
        int sceltaInt;
        int sceltaString;
        sleep(1000);
                System.out.print("\n"+ ConsoleColors.RED +"▓█████▄  █    ██  ███▄    █   ▄████ ▓█████  ▒█████   ███▄    █     ▒█████    █████▒   ▓█████▄▄▄█████▓▓█████  ██▀███   ███▄    █  ██▓▄▄▄█████▓▓██   ██▓");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED +"▒██▀ ██▌ ██  ▓██▒ ██ ▀█   █  ██▒ ▀█▒▓█   ▀ ▒██▒  ██▒ ██ ▀█   █    ▒██▒  ██▒▓██   ▒    ▓█   ▀▓  ██▒ ▓▒▓█   ▀ ▓██ ▒ ██▒ ██ ▀█   █ ▓██▒▓  ██▒ ▓▒ ▒██  ██▒");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED +"░██   █▌▓██  ▒██░▓██  ▀█ ██▒▒██░▄▄▄░▒███   ▒██░  ██▒▓██  ▀█ ██▒   ▒██░  ██▒▒████ ░    ▒███  ▒ ▓██░ ▒░▒███   ▓██ ░▄█ ▒▓██  ▀█ ██▒▒██▒▒ ▓██░ ▒░  ▒██ ██░");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED +"░▓█▄   ▌▓▓█  ░██░▓██▒  ▐▌██▒░▓█  ██▓▒▓█  ▄ ▒██   ██░▓██▒  ▐▌██▒   ▒██   ██░░▓█▒  ░    ▒▓█  ▄░ ▓██▓ ░ ▒▓█  ▄ ▒██▀▀█▄  ▓██▒  ▐▌██▒░██░░ ▓██▓ ░   ░ ▐██▓░");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED +"░▒████▓ ▒▒█████▓ ▒██░   ▓██░░▒▓███▀▒░▒████▒░ ████▓▒░▒██░   ▓██░   ░ ████▓▒░░▒█░       ░▒████▒ ▒██▒ ░ ░▒████▒░██▓ ▒██▒▒██░   ▓██░░██░  ▒██▒ ░   ░ ██▒▓░");
                sleep(250);
        System.out.print("\n"+ ConsoleColors.RED_BOLD +" ▒▒▓  ▒ ░▒▓▒ ▒ ▒ ░ ▒░   ▒ ▒  ░▒   ▒ ░░ ▒░ ░░ ▒░▒░▒░ ░ ▒░   ▒ ▒    ░ ▒░▒░▒░  ▒ ░       ░░ ▒░ ░ ▒ ░░   ░░ ▒░ ░░ ▒▓ ░▒▓░░ ▒░   ▒ ▒ ░▓    ▒ ░░      ██▒▒▒ ");
        sleep(250);
                System.out.print("\n"+ ConsoleColors.RED_BOLD +" ░ ▒  ▒ ░░▒░ ░ ░ ░ ░░   ░ ▒░  ░   ░  ░ ░  ░  ░ ▒ ▒░ ░ ░░   ░ ▒░     ░ ▒ ▒░  ░          ░ ░  ░   ░     ░ ░  ░  ░▒ ░ ▒░░ ░░   ░ ▒░ ▒ ░    ░     ▓██ ░▒░ ");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED_BOLD +" ░ ░  ░  ░░░ ░ ░    ░   ░ ░ ░ ░   ░    ░   ░ ░ ░ ▒     ░   ░ ░    ░ ░ ░ ▒   ░ ░          ░    ░         ░     ░░   ░    ░   ░ ░  ▒ ░  ░       ▒ ▒ ░░  ");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED_BOLD +"   ░       ░              ░       ░    ░  ░    ░ ░           ░        ░ ░                ░  ░           ░  ░   ░              ░  ░            ░ ░     ");
                sleep(250);
                System.out.print("\n"+ ConsoleColors.RED_BOLD +" ░                                                                                                                                            ░ ░     \n"+ConsoleColors.YELLOW_BOLD);
                sleep(500);
        while(true) {
        System.out.print("\n1)START\n2)OPTIONS\n3)EXIT\n> ");
        sceltaInt= sc.nextInt();
            switch (sceltaInt) {
                case 1:
                    avventura= new Avventura(nStanze);
                    avventura.inizia();

                    break;
                case 2:
                    System.out.print("Inserire quante stanze si vogliono\n> ");
                    sceltaInt = sc.nextInt();
                    if (sceltaInt > 0) {
                        sceltaInt = nStanze;
                    } else {
                        System.out.println("Numero non disponibile");
                    }
                    break;
                case 3:
                    System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLUE + "Addio\n");
                    exit(0);
                default:
                    System.out.println("Scelta non disponibile");
            }
        }
    }
}