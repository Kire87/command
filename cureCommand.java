
public class cureCommand implements Command {
	
	private Hero healer;
	private Hero target;
	
	public cureCommand(Hero healer, Hero target) {
		this.healer = healer;
		this.target = target;
	}

	@Override
	public void execute() {
		if(healer.getMagicPoints() >= 5) {
			healer.cure(target);
			System.out.println(healer.getName() + " cast CURE on " + target.getName() + ". " + healer.getName() + " lost 5 MP, there's now " + healer.getMagicPoints() + " MP remaing.");
			if(target.getHitPoints() > target.getMaxHitPoints()) {
				System.out.println(target.getName() + " recovered fully.");
				target.setHitPoints(target.getMaxHitPoints());
			}else {
				System.out.println(target.getName() + " recovered 10 HP and now has " + target.getHitPoints() + " HP.");
			}
		}else {
			System.out.println(healer.getName() + " tried casting CURE on " + target.getName() + ", but there wasn't enough MP, " + healer.getName() + " has only " + healer.getMagicPoints() + " MP.");
		}
		
	}

}
