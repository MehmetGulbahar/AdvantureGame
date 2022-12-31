
public class ToolStore extends normalLoc {

	public ToolStore(Player player) {
		super(player, "Magaza");
	}

	public boolean getLocation() {
		System.out.println("Magazaya Hosgeldiniz " + " Para Durumu = " + player.getMoney());
		System.out.println("1. Silahlar ");
		System.out.println("2. Zirhlar  ");
		System.out.println("3. Cikis    ");
		System.out.println("Seciminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		case 3: 
			System.out.println("Magazadan Cikildi");
			break;
		default:

		}
		return true;

	}

	public int armorMenu() {

		System.out.println("|||| ZIRHLAR ||||");
		System.out.println("1- Hafif   || Blocking '2' || Money '15' ");
		System.out.println("2- Orta    || Blocking '3' || Money '25' ");
		System.out.println("3- Agir    || Blocking '7' || Money '40' ");
		System.out.println("4- CIKIS : ");
		System.out.println("Lutfen Secim Yapiniz : ");
		int SelArmorID = scan.nextInt();
		return SelArmorID;

	}

	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Hafif";
			price = 25;
			break;
		case 2:
			avoid = 3;
			aName = "Orta";
			price = 35;
			break;
		case 3:
			avoid = 5;
			aName = "Agir";
			price = 45;
			break;
		default:
			System.out.println(" Gecersiz Islem ");
			break;
		}
		if (player.getMoney() >= price) {
			player.getInv().setArmor(avoid);
			player.getInv().setaName(aName);
			player.setMoney(player.getMoney() - price);
			System.out.println(aName + " Armor Satin Aldiniz " + " Engellenen Hasariniz  = " + player.getInv().getArmor());
		} else {
			System.out.println("Yetersiz Bakiye !");
		}
	}

	public int weaponMenu() {

		System.out.println("|||| SILAHLAR ||||");
		System.out.println("1- Tabanca || Damage '2' || Money '25' ");
		System.out.println("2- Kilic   || Damage '3' || Money '35' ");
		System.out.println("3- Tufek   || Damage '7' || Money '45' ");
		System.out.println("4- CIKIS : ");
		System.out.println("Lutfen Secim Yapiniz : ");
		int SelWeaponID = scan.nextInt();
		return SelWeaponID;

	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Kilic";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Tufek";
			price = 45;
			break;
		default:
			System.out.println("Gecersiz Islem ");
			break;

		}
		if (player.getMoney() > price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney() - price);
			System.out.println(wName + " Satin Aldiniz - Eski Hasariniz  " + player.getDamage() + " Yeni Hasariniz "
					+ player.getTotalDamage());
			System.out.println("Kalan Bakiye = " + player.getMoney());
		} else {
			System.out.println("Yetersiz Bakiye !");
		}
	}
}
