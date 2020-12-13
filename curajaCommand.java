
public class curajaCommand implements Command {
	
	private Hero healer;
	private Hero target;
	
	public curajaCommand(Hero healer, Hero target) {
		this.healer = healer;
		this.target = target;
	}

	@Override
	public void execute() {
		if(healer.getMagicPoints() >= 25) {
			healer.cure(target);
			System.out.println(healer.getName() + " cast CURAJA on " + target.getName() + ". " + healer.getName() + " lost 25 MP, there's now " + healer.getMagicPoints() + " MP remaing.");
			if(target.getHitPoints() > target.getMaxHitPoints()) {
				System.out.println(target.getName() + " recovered fully.");
				target.setHitPoints(target.getMaxHitPoints());
			}else {
				System.out.println(target.getName() + " recovered 50 HP and now has " + target.getHitPoints() + " HP.");
			}
		}else {
			System.out.println(healer.getName() + " tried casting CURAJA on " + target.getName() + ", but there wasn't enough MP, " + healer.getName() + " has only " + healer.getMagicPoints() + " MP.");
		}
		
	}

}
