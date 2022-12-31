import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void Login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Hosgeldiniz !");
		System.out.println("Oyun Baslamadan Once Isminizi Giriniz : ");
		String playerName = scan.nextLine();
		System.out.println("||||||||||||||||||||");
		System.out.println("||Hosgeldin " + playerName + "||");
		System.out.println("||||||||||||||||||||");
		player = new Player(playerName);
		player.SelectCha();
		start();
	}

	public void start() {
		while (true) {
			System.out.println("");
			System.out.println("===========================================");
			System.out.println("Lutfen Basmalak Istediginiz Yeri Seciniz : ");
			System.out.println("===========================================");
			System.out.println("1.Guvenli Ev --> Burada Savas Yok (Can Yenileniyor!)");
			System.out.println("2.Magara     --> Burada Karsina 'ZOMBI' Cikabilir!    ");
			System.out.println("3.Orman      --> Burada Karsina 'VAMPIR' Cikabilir!   ");
			System.out.println("4.Nehir      --> Burada Karsina 'AYI' Cikabilir!      ");
			System.out.println("5.Magaza     --> Buradan 'EKIPMAN' Satin Alabilirsiniz.");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.println("Lutfen Gecerli Bir Konum Seciniz !");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getClass().getName().equals("SafeHouse")) {
				if (player.getInv().isFireWood() && player.getInv().isFood() && player.getInv().isWater()){
					System.out.println("**** Win The Game ****");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Oyun Bitti!");
				break;
			}
		}
	}
}
