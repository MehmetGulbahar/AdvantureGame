
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.Count();
		System.out.println("Suanda = " + this.getName());
		System.out.println("Dikkatli Ol ! " + obsCount + " tane " + obstacle.getName() + " yasiyor.");
		System.out.println("<H>it or <R>un");
		String SelCase = scan.next();
		SelCase = SelCase.toUpperCase();
		if (SelCase.equals("H")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " Bolgesindeki Butun Dusmanlari Temizlediniz!");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Kazandiniz ");
					player.getInv().setFood(true);
				} else if (this.award.equals("FireWood") && player.getInv().isFireWood() == false) {
					System.out.println(this.award + "Kazandiniz");
					player.getInv().setFireWood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Kazandiniz ");
					player.getInv().setWater(true);
				}
				return true;
			}

			if (player.getHealthy() <= 0) {
				System.out.println("You're Dead,Try again.");
				return false;
			}

		}
		return true;
	}

	public boolean combat(int obsCount) {
		int defObsHealth = obstacle.getHealth();
		for (int i = 0; i < obsCount; i++) {
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.println("----  <H>it or <R>un  ----");
				String SelCase = scan.next();
				SelCase = SelCase.toUpperCase();
				if (SelCase.equals("H")) {
					System.out.println("\nHasar Verildi!");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHits();
					if (obstacle.getHealth() > 0) {
						System.out.println("*-----------------*");
						System.out.println("Monster Hit You! ");
						player.setHealthy(player.getDamage() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHits();
					}
				} else {
					return false;
				}

			}
			if (obstacle.getHealth() <= 0 && player.getHealthy() > 0) {
				System.out.println("Dusmanlari Ezip Gectin ! ");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Guncel Bakiyeniz = " + player.getMoney());
				obstacle.setHealth(defObsHealth);

			} else {
				return false;
			}
			System.out.println("--------------------");
		}
		return true;
	}

	public void afterHits() {
		System.out.println(player.getName() + " Cani =  " + player.getHealthy());
		System.out.println(obstacle.getName() + " Cani =  " + obstacle.getHealth());
		System.out.println();
	}

	public void playerStats() {
		System.out.println("Oyuncu Degerleri Goruntuleniyor\n-------------");
		System.out.println("Can   = " + player.getHealthy());
		System.out.println("Hasar = " + player.getTotalDamage());
		System.out.println("Para  = " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah = " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zirh = " + player.getInv().getArmor());
		}

	}

	public void enemyStats() {
		System.out.println(obstacle.getName() + " \n------------- ");
		System.out.println("Can   = " + obstacle.getHealth());
		System.out.println("Hasar = " + obstacle.getDamage());
		System.out.println("Odul  = " + obstacle.getAward());

	}
}
