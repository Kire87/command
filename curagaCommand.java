
public class curagaCommand implements Command {
	
	private Hero healer;
	private Hero target;
	
	public curagaCommand(Hero healer, Hero target) {
		this.healer = healer;
		this.target = target;
	}

	@Override
	public void execute() {
		if(healer.getMagicPoints() >= 20) {
			healer.cure(target);
			System.out.println(healer.getName() + " cast CURAGA on " + target.getName() + ". " + healer.getName() + " lost 20 MP, there's now " + healer.getMagicPoints() + " MP remaing.");
			if(target.getHitPoints() > target.getMaxHitPoints()) {
				System.out.println(target.getName() + " recovered fully.");
				target.setHitPoints(target.getMaxHitPoints());
			}else {
				System.out.println(target.getName() + " recovered 40 HP and now has " + target.getHitPoints() + " HP.");
			}
		}else {
			System.out.println(healer.getName() + " tried casting CURAGA on " + target.getName() + ", but there wasn't enough MP, " + healer.getName() + " has only " + healer.getMagicPoints() + " MP.");
		}
		
	}

}
