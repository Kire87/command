
public class Hero {
	
	private String name;
	private int hitPoints;
	private int maxHitPoints;
	private int magicPoints;
	private int maxMagicPoints;
	
	public Hero(String name, int hitPoints, int maxHitPoints, int magicPoints, int maxMagicPoints) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.maxHitPoints = maxHitPoints;
		this.magicPoints = magicPoints;
		this.maxMagicPoints = maxMagicPoints;
	}
	
	public void cure(Hero hero) {
		hero.hitPoints += 10;
		magicPoints -= 5;
	}
	
	public void cura(Hero hero) {
		hero.hitPoints += 20;
		magicPoints -= 10;
	}
	
	public void curasa(Hero hero) {
		hero.hitPoints += 30;
		magicPoints -= 15;
	}
	
	public void curaga(Hero hero) {
		hero.hitPoints += 40;
		magicPoints -= 20;
	}
	
	public void curaja(Hero hero) {
		hero.hitPoints += 50;
		magicPoints -= 25;
	}
	
	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public int getMaxHitPoints() {
		return this.maxHitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}
	
	public int getMagicPoints() {
		return this.magicPoints;
	}
	
	public int getMaxMagicPoints() {
		return this.maxMagicPoints;
	}
}
