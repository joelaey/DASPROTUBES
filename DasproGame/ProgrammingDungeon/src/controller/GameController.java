package controller;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Player;
import model.Enemy;
import model.Item;
import map.Map;
import model.Armor;
import model.Weapon;

public class GameController {

    HashMap<String, Player> mainCharacter = new HashMap<>();
    HashMap<String, Enemy> enemyPositions = new HashMap<>();
    HashMap<String, Armor> itemArmors = new HashMap<>();
    HashMap<String, Weapon> itemWeapons = new HashMap<>();
    HashMap<String, Item> itemPositions = new HashMap<>();
    ArrayList<Item> inventory = new ArrayList<>();

    public Map gameMap  = new Map();

    public void loadMap() {

        char[][] initMap = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'P', '#', 'I', ' ', ' ', ' ', 'E', '#', '#', '#', 'I', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', 'E', '#'},
            {'#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', '#', ' ', '#', 'I', '#', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', 'X', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', 'I', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', '#'},
            {'#', '#', 'I', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', 'B', '#'},
            {'#', '#', '#', '#', 'I', '#', '#', ' ', '#', 'E', '#', ' ', ' ', 'E', '#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', 'I', '#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };
        setUpMapAtribut();

        gameMap.setMap(initMap);
    }

    public void displayMap() {

        setUpMapAtribut();
        settingMap();

        char[][] generateMap = gameMap.getMap();

        for (char[] row : generateMap) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void settingMap(){
        char[][] currentMap = gameMap.getMap();
    
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[i].length; j++) {
                String currentPosition = i + "," + j;
    
                if (enemyPositions.containsKey(currentPosition)) {
                    currentMap[i][j] = 'E'; 
                } else if (itemWeapons.containsKey(currentPosition)) {
                    currentMap[i][j] = 'W'; 
                } else if (itemArmors.containsKey(currentPosition)) {
                    currentMap[i][j] = 'A'; 
                }
            }
        }
    
        gameMap.setMap(currentMap);
    }
    

    public void movePlayer(String direction) {
        char[][] gameMapArray = gameMap.getMap();
        int playerX = -1;
        int playerY = -1;
    
            for (int i = 0; i < gameMapArray.length; i++) {
                for (int j = 0; j < gameMapArray[i].length; j++) {
                    if (gameMapArray[i][j] == 'P') {
                        playerX = i;
                        playerY = j;
                        break;
                    }
                }
            }

            switch (direction.toUpperCase()) {
                case "W":
                    if (playerX > 0 && gameMapArray[playerX - 1][playerY] != '#') {
                        gameMapArray[playerX][playerY] = ' ';
                        gameMapArray[playerX - 1][playerY] = 'P';
                        gameMap.setMap(gameMapArray);
                    }
                    break;
                case "A":
                    if (playerY > 0 && gameMapArray[playerX][playerY - 1] != '#') {
                        gameMapArray[playerX][playerY] = ' ';
                        gameMapArray[playerX][playerY - 1] = 'P';
                        gameMap.setMap(gameMapArray);
                    }
                    break;
                case "S":
                    if (playerX < gameMapArray.length - 1 && gameMapArray[playerX + 1][playerY] != '#') {
                        gameMapArray[playerX][playerY] = ' ';
                        gameMapArray[playerX + 1][playerY] = 'P';
                        gameMap.setMap(gameMapArray);
                    }
                    break;
                case "D":
                    if (playerY < gameMapArray[0].length - 1 && gameMapArray[playerX][playerY + 1] != '#') {
                        gameMapArray[playerX][playerY] = ' ';
                        gameMapArray[playerX][playerY + 1] = 'P';
                        gameMap.setMap(gameMapArray);
                    }
                    break;
                default:
                    break;
            }
        }

    public void tampilanAwal(){
        System.out.println("\n" + //
                " ██████╗░██████╗░░█████╗░░██████╗░██████╗░░█████╗░███╗░░░███╗███╗░░░███╗██╗███╗░░██╗░██████╗░\n" + //
                " ██╔══██╗██╔══██╗██╔══██╗██╔════╝░██╔══██╗██╔══██╗████╗░████║████╗░████║██║████╗░██║██╔════╝░\n" + //
                " ██████╔╝██████╔╝██║░░██║██║░░██╗░██████╔╝███████║██╔████╔██║██╔████╔██║██║██╔██╗██║██║░░██╗░\n" + //
                " ██╔═══╝░██╔══██╗██║░░██║██║░░╚██╗██╔══██╗██╔══██║██║╚██╔╝██║██║╚██╔╝██║██║██║╚████║██║░░╚██╗\n" + //
                " ██║░░░░░██║░░██║╚█████╔╝╚██████╔╝██║░░██║██║░░██║██║░╚═╝░██║██║░╚═╝░██║██║██║░╚███║╚██████╔╝\n" + //
                " ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝░╚═════╝░\n" + //
                "\n" + //
                "\t\t██████╗░██╗░░░██╗███╗░░██╗░██████╗░███████╗░█████╗░███╗░░██╗\n" + //
                "\t\t██╔══██╗██║░░░██║████╗░██║██╔════╝░██╔════╝██╔══██╗████╗░██║\n" + //
                "\t\t██║░░██║██║░░░██║██╔██╗██║██║░░██╗░█████╗░░██║░░██║██╔██╗██║\n" + //
                "\t\t██║░░██║██║░░░██║██║╚████║██║░░╚██╗██╔══╝░░██║░░██║██║╚████║\n" + //
                "\t\t██████╔╝╚██████╔╝██║░╚███║╚██████╔╝███████╗╚█████╔╝██║░╚███║\n" + //
                "\t\t╚═════╝░░╚═════╝░╚═╝░░╚══╝░╚═════╝░╚══════╝░╚════╝░╚═╝░░╚══╝");

                System.out.println("\n\t============================ Hello Si Paling IT =============================");
                System.out.println("\t\t\t\t  Pilih Menu Dibawah Ini :");
                System.out.println("\t\t\t\t      1. Start Game");
                System.out.println("\t\t\t\t\t2. Credits");
                System.out.println("\t\t\t\t\t3. Keluar");
                System.out.println("\t=============================================================================");
                System.out.print("\t\t\t\t   Masukkan Pilihanmu : ");
    }

    public void credit(){
        System.out.println("\n\n\n\n================== Credits ===================");
        System.out.println("      Game Title : Programming Dungeon");
        System.out.println("  Developed by : M. Agung Julyansyah (Julay)");
        System.out.println("\n              Contributors :");
        System.out.println("               - Angin malam");
        System.out.println("   - Gudang garam filter (filihan terbaik)");
        System.out.println("         - Kopi hitam tidak diaduk");
        System.out.println("\n              Special Thanks :");
        System.out.println("                - Tuhan YME");
        System.out.println("              - Mamah & Papah");
        System.out.println("                - Kost Haqi");
        System.out.println("\n  © 2023 Julay'sCorp. All rights reserved.");
        System.out.println("==============================================\n\n");
    }
    
    public void setUpCharacter(){
        Scanner sc = new Scanner(System.in);

        Player mainChar = new Player();

        mainChar.setIdPlayer("P1237050062")
        .setEquippedArmor(null)
        .setEquippedWeapon(null)
        .setInventory(null)
        .setAttackPower(20)
        .setHealth(100);

        mainCharacter.put(mainChar.getIdPlayer(), mainChar);

        System.out.println("\n\nSelamat datang di PROGRAMMING DUNGEON wahai si paling IT !");
        System.out.print("Siapa Nama Anda : ");

        String namaPlayer = sc.nextLine();
        mainChar.setName(namaPlayer);

        mainCharacter.put(mainChar.getIdPlayer(), mainChar);
    }

    public void prologGame(){

        Scanner sc = new Scanner(System.in);

        System.out.println("\n? ? ? ? ? ? ? : ");
        System.out.println("Halo " + mainCharacter.get("P1237050062").getName() + " , Aku adalah Ujang 4.0 .");
        System.out.println("\nTask : Ketik (Ujang 4.0 ?)");
        String jawaban1 = sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.print(jawaban1);
        System.out.println("\n\nUjang 4.0 : ");
        System.out.println("Iya, namaku Ujang 4.0 , Aku adalah wujud dari ketakutan mu akan kekejaman dunia IT ini");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("Namamu aneh sekali sebenarnya sebagai apa kamu disini ?");
        System.out.println("Dan dimana aku ?");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Kamu berada di antah berantah, aku pun tidak tau dimana ini sebenarnya hehe");
        System.out.println("Tapi tenang saja, aku baik kok nggak gigit");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("Kenapa aku bisa ada ditempat seperti ini?");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Sudah jangan banyak bertanya, biar aku jelaskan apa yang sebenarnya terjadi");
        System.out.println("dan apa tujuan yang harus kau capai");
        sc.nextLine();
        System.out.println("\n\n*Ujang 4.0 menjelaskan apa yang sebernarnya terjadi kepadamu . . . .");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("Aku tidak mengerti, tapi tak apa yang jelas apa yang harus kulakukan ?");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Kamu harus mengalahkan semua musuh yang ada di dalam dungeon ini, dan kamu harus");
        System.out.println("mengalahkan boss yang ada di suatu ruangan di dungeon ini, konon katanya boss ini");
        sc.nextLine();
        System.out.println("sangat menakutkan dan sulit untuk dikalahkan. Tetapi tenang saja, didalam dungeon");
        System.out.println("itu tersebar beberapa item yang bisa memperkuat dirimu dan membantumu untuk mengalahkan");
        sc.nextLine();
        System.out.println("semua musuh yang ada di dalam dungeon itu. Dan tentu mengambil kunci untuk keluar dari");
        System.out.println("tempat ini setelah kamu mengalahkan bossnya.");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("Boss? semenakutkan apa memangnya ? seperti apa wujudnya ? aku tidak pernah takut.");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Dari informasi yang kudapatkan dari ChatGPT boss ini sangat kuat dan sulit untuk");
        System.out.println("dikalahkan, konon siapapun yang berhadapdan dengannya akan dibuat tak berdaya.");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("Apa boss ini mempunyai nama ?");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Ya, tentu saja, menurut ChatGPT boss ini memiliki nama (UUPI) atau UTS UAS");
        System.out.println("PENGENALAN INFORMATIKA.");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("(*Merinding sampai kejang kejang ketika mengetahuinya)");
        sc.nextLine();
        System.out.println("\nUjang 4.0 : ");
        System.out.println("Sudah jangan ketakutan seperti itu, cepat masuk dan ingat apa yang kukatakan tadi");
        System.out.println("aku yakin kamu bisa melalui semuanya, Good Luck !");
        sc.nextLine();
        System.out.println("\n" + mainCharacter.get("P1237050062").getName() + " : ");
        System.out.println("(*terdiam membisu)");
        sc.nextLine();
        System.out.println("\n\nUjang 4.0 pun menghilang dan kamu mulai masuk kedalam dungeon itu . . . . .");

    }
    public void menuCharacter(){
        System.out.println("\nMenu Player : ");
        System.out.println("1. Lihat stats detail");
        System.out.println("2. Akses inventory");
        System.out.println("3. Kembali ke game");
    }
    public void showStatsCharacter(){
        System.out.println("Nama : " + mainCharacter.get("P1237050062").getName());
        System.out.println("Health : " + mainCharacter.get("P1237050062").getHealth());
        System.out.println("Attack Power : " + mainCharacter.get("P1237050062").getAttackPower());
    }

    public void setUpMapAtribut() {

        addArmor((Armor) new Armor()
                .setHealthBoost(20)
                .setName("Do'a Orang tua")
                .setDescription("Item ini dapat melindungi mu dari kerasnya dunia")
                .setPosition(8,2)
                .setIdItem("A01"));
    
        addWeapon((Weapon) new Weapon()
                .setAttackBoost(20)
                .setName("Mulut jordan")
                .setDescription("Mulut ini memiliki tingkat ketajaman yang sangat tajam da pedas")
                .setPosition(1,3)
                .setIdItem("W01"));
    
        addArmor((Armor) new Armor()
                .setHealthBoost(30)
                .setName("Kemeja jurusan")
                .setDescription("Kemeja ini dapat membuat musuh tau bahwa anda anak IT")
                .setPosition(1,11)
                .setIdItem("A02"));
    
        addWeapon((Weapon) new Weapon()
                .setAttackBoost(40)
                .setName("Kursus Hackerrank")
                .setDescription("Dengan mengikuti kursus ini, anda menjadi lebih jago")
                .setPosition(7,6)
                .setIdItem("W02"));
    
        addWeapon((Weapon) new Weapon()
                .setAttackBoost(30)
                .setName("Bimbel sama ujang")
                .setDescription("Sesuai dengan namanya dengan bimbel bersama ujang ini menambah pengetahuan anda")
                .setPosition(9,4)
                .setIdItem("W03"));
    
        addArmor((Armor) new Armor()
                .setHealthBoost(100)
                .setName("Motivasi di KODIM")
                .setDescription("Dengan motivasi dari kodim ini akan memperkuat mental anda.")
                .setPosition(3,17)
                .setIdItem("A03"));
    
        addWeapon((Weapon) new Weapon()
                .setAttackBoost(100)
                .setName("Fokus di PDP")
                .setDescription("Dengan fokus dalam matkul pdp, Ini akan memperkuat logic dan insting anda sebagai programmer.")
                .setPosition(11,13)
                .setIdItem("W04"));
    
        addEnemy((Enemy) new Enemy()
                .setIdEnemy("E01")
                .setBuffHealth(100)
                .setBuffAttackPower(50)
                .setPosition(1,7)
                .setHealth(120)
                .setAttackPower(35)
                .setName("Praktikum Fisika Dasar"));
    
        addEnemy((Enemy) new Enemy()
                .setIdEnemy("E02")
                .setBuffHealth(150)
                .setBuffAttackPower(75)
                .setPosition(2,18)
                .setHealth(150)
                .setAttackPower(50)
                .setName("UAS Kalkulus"));
    
        addEnemy((Enemy) new Enemy()
                .setIdEnemy("B055")
                .setBuffHealth(200)
                .setBuffAttackPower(200)
                .setPosition(8,18)
                .setHealth(500)
                .setAttackPower(500)
                .setName("UTS & UAS Pengenalan Informatika"));
    
        addEnemy((Enemy) new Enemy()
                .setIdEnemy("E03")
                .setBuffHealth(150)
                .setBuffAttackPower(75)
                .setPosition(9,9)
                .setHealth(200)
                .setAttackPower(250)
                .setName("MONITOR 2023"));
    
        addEnemy((Enemy) new Enemy()
                .setIdEnemy("E04")
                .setBuffHealth(180)
                .setBuffAttackPower(90)
                .setPosition(9,13)
                .setHealth(430)
                .setAttackPower(350)
                .setName("RBL Scratch Fisika Dasar"));
    }
    
    private void addArmor(Armor armor) {
        itemArmors.put(armor.getIdItem(), armor);
    }
    
    private void addWeapon(Weapon weapon) {
        itemWeapons.put(weapon.getIdItem(), weapon);
    }
    
    private void addEnemy(Enemy enemy) {
        enemyPositions.put(enemy.getIdEnemy(), enemy);
    }
    

    public void displayInventory() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Inventory =====");
        System.out.println("No. | ID     | Name        | Description          | Stats");

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.printf("%-4d | %-6s | %-11s | %-20s | ", i + 1, item.getIdItem(), item.getName(), item.getDescription());

            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                System.out.println("Damage: " + weapon.getAttackBoost());
            } else if (item instanceof Armor) {
                Armor armor = (Armor) item;
                System.out.println("Defense: " + armor.getHealthBoost());
            } else {
                System.out.println("No Stats");
            }
        }
        System.out.println("Item apa yang mau anda pakai (Masukkan Id Item) : ");
        String pilihan = sc.nextLine();

        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getIdItem().equals(pilihan)) {
                Item selectedItem = inventory.get(i);
                
                if (selectedItem instanceof Weapon) {
                    useWeaponFromInventory(i);
                } else if (selectedItem instanceof Armor) {
                    useArmorFromInventory(i);
                } else {
                    System.out.println("Item tersebut tidak dapat digunakan.");
                }
                break; 
            }
        }
    }

    public boolean inventoryContainsKey() {
        for (Item item : inventory) {
            if (item instanceof Key) {
                return true;
            }
        }
        return false;
    }

    public boolean isBossDefeated() {
        char[][] currentMap = gameMap.getMap();
        return currentMap[5][19] == 'P'; 
    }


    public void interaksiPemain() {
        char[][] gameMapArray = gameMap.getMap();
        int playerX = -1;
        int playerY = -1;

        for (int i = 0; i < gameMapArray.length; i++) {
            for (int j = 0; j < gameMapArray[i].length; j++) {
                if (gameMapArray[i][j] == 'P') {
                    playerX = i;
                    playerY = j;
                    break;
                }
            }
        }

        String playerPosition = playerX + "," + playerY;

        if (itemPositions.containsKey(playerPosition)) {
            Item currentItem = itemPositions.get(playerPosition);
            System.out.println("Ini item : " + currentItem.getName() + " - " + currentItem.getDescription());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Apakah Anda ingin mengambil item ini? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                inventory.add(currentItem);
                itemPositions.remove(playerPosition); 
                System.out.println("Anda telah mengambil " + currentItem.getName());
            }
        }

        if (enemyPositions.containsKey(playerPosition)) {
            Enemy currentEnemy = enemyPositions.get(playerPosition);
            System.out.println("Ini musuh : Health = " + currentEnemy.getHealth() + ", Attack = " + currentEnemy.getAttackPower());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Apakah Anda ingin bertarung dengan musuh ini? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                battle();
            }
        }
    }

    Enemy currentEnemy = null;

    public void battle() {

        while (mainCharacter.get("P1237050062").getHealth() > 0 && currentEnemy.getHealth() > 0) {
            System.out.println("\n==== Pertarungan Dimulai ====");
            System.out.println("Musuh: " + currentEnemy.getName());
            System.out.println("Health Musuh: " + currentEnemy.getHealth());
            System.out.println("Attack Musuh: " + currentEnemy.getAttackPower());
            System.out.println("-----------------------------");
            System.out.println("Pemain: " + mainCharacter.get("P1237050062").getName());
            System.out.println("Health Pemain: " + mainCharacter.get("P1237050062").getHealth());
            System.out.println("Attack Pemain: " + mainCharacter.get("P1237050062").getAttackPower());
            System.out.println("-----------------------------");

                int damageDealt = mainCharacter.get("P1237050062").getAttackPower();
                currentEnemy.setHealth(currentEnemy.getHealth() - damageDealt);
                System.out.println("Anda menyerang " + currentEnemy.getName() + " sebesar " + damageDealt + " damage!");

            if (currentEnemy.getHealth() > 0) {
                int damageReceived = currentEnemy.getAttackPower();
                mainCharacter.get("P1237050062").setHealth(mainCharacter.get("P1237050062").getHealth() - damageReceived);
                System.out.println(currentEnemy.getName() + " menyerang Anda sebesar " + damageReceived + " damage!");
            }
        }

        if (mainCharacter.get("P1237050062").getHealth() > 0) {
            mainCharacter.get("P1237050062").setHealth(100);

            if (currentEnemy.getHealth() <= 0) {
                int playerHealth = mainCharacter.get("P1237050062").getHealth();
                int playerAttackPower = mainCharacter.get("P1237050062").getAttackPower();

                int buffedHealth = playerHealth + currentEnemy.getBuffHealth();
                int buffedAttackPower = playerAttackPower + currentEnemy.getBuffAttackPower();

                mainCharacter.get("P1237050062").setHealth(buffedHealth);
                mainCharacter.get("P1237050062").setAttackPower(buffedAttackPower);

                System.out.println("\nSelamat, Anda telah mengalahkan musuh! Health Anda telah dipulihkan menjadi " + buffedHealth);
                System.out.println("Anda menerima buff: Health +" + currentEnemy.getBuffHealth() + " Attack +" + currentEnemy.getBuffAttackPower());
            }
        }
        
    }

    public void useWeaponFromInventory(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                mainCharacter.get("P1237050062").setEquippedWeapon(weapon);
                System.out.println("Senjata " + weapon.getName() + " telah diaktifkan!");
            } else {
                System.out.println("Item bukan senjata.");
            }
        } else {
            System.out.println("Index di luar rentang inventory.");
        }
    }
    
    public void useArmorFromInventory(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            if (item instanceof Armor) {
                Armor armor = (Armor) item;
                mainCharacter.get("P1237050062").setEquippedArmor(armor);
                System.out.println("Armor " + armor.getName() + " telah diaktifkan!");
            } else {
                System.out.println("Item bukan armor.");
            }
        } else {
            System.out.println("Index di luar rentang inventory.");
        }
    }
    

}
