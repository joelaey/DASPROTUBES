import java.util.Scanner;
import controller.GameController;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        boolean isGameRunning = true;

        while (isGameRunning) {
            gameController.tampilanAwal();
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    gameController.setUpCharacter();
                    gameController.prologGame();
                    gameController.loadMap();
                    gameController.setUpMapAtribut();
                    gameController.settingMap();
                    gameController.displayMap();
                    boolean isPlayerInDungeon = true;

                    while (isPlayerInDungeon) {
                        System.out.println("\nPilih arah (W/A/S/D) dan ketik E untuk masuk ke menu character : ");
                        String direction = scanner.next();
                        gameController.movePlayer(direction);
                        gameController.interaksiPemain();
                        gameController.displayMap();

                        if (direction.equals("E")){
                            boolean isPlayerMenu = true;

                            while(isPlayerMenu){

                                String playerOption = direction;
                                switch (playerOption) {
                                    case "E":
                                        gameController.menuCharacter();
                                        int playerChoice = scanner.nextInt();

                                        switch (playerChoice) {
                                            case 1:
                                                gameController.showStatsCharacter();
                                                break;
                                            case 2:
                                                gameController.displayInventory();
                                                break;
                                            case 3:
                                                isPlayerMenu = false;
                                                break;
                                            default:
                                                System.out.println("Pilihan tidak valid.");
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println("Tekan E !");
                                        break;
                                }

                                char[][] currentMap = gameController.gameMap.getMap();
                                if (currentMap[5][19] == 'P') {
                                    System.out.println("Anda keluar dari game.");
                                    isPlayerInDungeon = false;
                                    isPlayerMenu = false;
                                }

                                if (gameController.inventoryContainsKey() || gameController.isBossDefeated()) {
                                    System.out.println("Anda telah menyelesaikan game!");
                                    isGameRunning = false;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    gameController.credit();
                    break;
                case 3:
                    isGameRunning = false;
                    System.out.println("Terima kasih telah bermain!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        scanner.close();
    }
}
