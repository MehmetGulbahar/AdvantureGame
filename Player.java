import java.util.Scanner;

public class Player {

	private int damage, healthy, money,rHealth;
	private String name, cName;
	Inventory inv;
	Scanner scan = new Scanner(System.in);

	public void SelectCha() {
		switch (ChaMenu()) {
		
		case 1:
			// Samuray Secildi.
			initPlayer("Samuray", 5,21,35);
			break;
		case 2:
			// Okcu Secildi.
			initPlayer("Okcu", 7,18,40);
			break;
		case 3:
			// Sovalye Secildi.
			initPlayer("Sovalye", 8,24,30);
			break;
		default:
			initPlayer("Samuray", 5,21,35);
			break;

		}

		System.out.println("Karakter : " + getcName() + "\t Hasar = " + getDamage() + "\t Saglik = " + getHealthy()
				+ "\t Para = " + getMoney());

	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
		
	}
	
	
	
	public void initPlayer(String name,int dmg,int hlt,int money) {
		setcName("Samuray");
		setDamage(dmg);
		setHealthy(hlt);
		setMoney(money);
		setrHealth(healthy);
	}

	public int ChaMenu() {
		System.out.println("Lutfen Karakter Seciniz :");
		System.out.println("1- Samuray  || Damage  '5'  || Healthy '21' || Money '35' ");
		System.out.println("2- Okcu     || Damage  '7'  || Healthy '18' || Money '40' ");
		System.out.println("3- Sovalye  || Damage  '8'  || Healthy '24' || Money '30' ");
		System.out.println("Seciminiz = ");
		int CharId = scan.nextInt();
		while (CharId < 1 || CharId > 3) {
			System.out.println("Gecerli Bir Secim Yapiniz.");
			CharId = scan.nextInt();

		}

		return CharId;
	}

	public Player(String name) {
        this.inv = new Inventory();
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public int getrHealth() {
		return rHealth;
	}
	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	

}
