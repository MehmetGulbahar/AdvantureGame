
public class SafeHouse extends normalLoc {

	public SafeHouse(Player player) {
		super(player, "Guvenli Ev");	
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getHealthy());
		System.out.println("Su an Guvenli Bolgedesiniz. \nCaniniz Iyilestiriliyor");
		return true;
	}

}
