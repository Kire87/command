
public class curasaCommand implements Command {
	
	private Hero healer;
	private Hero target;
	
	public curasaCommand(Hero healer, Hero target) {
		this.healer = healer;
		this.target = target;
	}

	@Override
	public void execute() {
		if(healer.getMagicPoints() >= 15) {
			healer.cure(target);
			System.out.println(healer.getName() + " cast CURASA on " + target.getName() + ". " + healer.getName() + " lost 15 MP, there's now " + healer.getMagicPoints() + " MP remaing.");
			if(target.getHitPoints() > target.getMaxHitPoints()) {
				System.out.println(target.getName() + " recovered fully.");
				target.setHitPoints(target.getMaxHitPoints());
			}else {
				System.out.println(target.getName() + " recovered 30 HP and now has " + target.getHitPoints() + " HP.");
			}
		}else {
			System.out.println(healer.getName() + " tried casting CURASA on " + target.getName() + ", but there wasn't enough MP, " + healer.getName() + " has only " + healer.getMagicPoints() + " MP.");
		}
		
	}

}
