import java.util.Scanner;

public class Phantasy {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Hero[] heroes = new Hero[4];
		
		String name;
		int hitPoints;
		int maxHitPoints;
		int magicPoints;
		int maxMagicPoints;
		
		int aux = 0;
		
		String targetName;
		String healerName;
		String spell;
		
		int targetIndex = 0;
		int healerIndex = 0;
		
		Command command;
		
		System.out.println("Welcome to Phantasy! You will now create your characters.");
		
		for(int i = 0; i < 4; i++) {
			System.out.println("What is the name of the hero " + (i + 1) + "?");
			name = sc.nextLine();
			while(name.trim().length() <= 0) {
				System.out.println("What? I din't hear well...\nWhat is the name of the hero " + (i + 1) + "?");
				name = sc.nextLine();
			}
			
			System.out.println("How much HP he has when he's at full health?");
			maxHitPoints = sc.nextInt();
			sc.nextLine();
			while(maxHitPoints <= 0) {
				System.out.println("Huh? Are you sure? I think he has more than that...\nHow much HP he has when he's at full health?");
				maxHitPoints = sc.nextInt();
				sc.nextLine();
			}
			
			
			System.out.println("How much HP he has now?");
			hitPoints = sc.nextInt();
			sc.nextLine();
			while(hitPoints <= 0 || hitPoints > maxHitPoints) {
				System.out.println("Huh? Don't lie to me!\nHow much HP he has now?");
				hitPoints = sc.nextInt();
				sc.nextLine();
			}
			
			System.out.println("How much MP he has when he's at his maximum?");
			maxMagicPoints = sc.nextInt();
			sc.nextLine();
			while(maxMagicPoints <= 0) {
				System.out.println("I don't think there is a single soul in this world that can't use magic! Stop kidding me!\nHow much MP he has when he's at his maximum?");
				maxMagicPoints = sc.nextInt();
				sc.nextLine();
			}
			
			System.out.println("How much MP he has now?");
			magicPoints = sc.nextInt();
			sc.nextLine();
			while(magicPoints < 0 || magicPoints > maxMagicPoints) {
				System.out.println("Nah, that's not possible, please answer me truthfully.\nHow much MP he has now?");
				magicPoints = sc.nextInt();
				sc.nextLine();
			}
			
			heroes[i] = new Hero(name, hitPoints, maxHitPoints, magicPoints, maxMagicPoints);
		}
		
		System.out.println("Why don't you try healing your heroes before setting onward?");
		
		while(aux != 4) {
			System.out.println("1 - Heal a hero\n2 - Check the heroes statuses (HP and MP)\n3 - List healing spells\n4 - Venture forward");
			aux = sc.nextInt();
			sc.nextLine();
			
			switch(aux) {
				case 1:
					System.out.println("What hero do you want to heal?");
					targetName = sc.nextLine();
					System.out.println("Who will heal him?");
					healerName = sc.nextLine();
					for(int i = 0; i < 4; i++) {
						if(heroes[i].getName().equals(targetName)) {
							targetIndex = i;
						}
						if(heroes[i].getName().equals(healerName)) {
							healerIndex = i;
						}
					}
					System.out.println("Which healing spell will " + healerName + " cast upon " + targetName + "? (please type it in capital letters)");
					spell = sc.nextLine();
					
					switch(spell) {
						case "CURE":
							command = new cureCommand(heroes[healerIndex], heroes[targetIndex]);
							command.execute();
							break;
							
						case "CURA":
							command = new curaCommand(heroes[healerIndex], heroes[targetIndex]);
							command.execute();
							break;
							
						case "CURASA":
							command = new curasaCommand(heroes[healerIndex], heroes[targetIndex]);
							command.execute();
							break;
							
						case "CURAGA":
							command = new curagaCommand(heroes[healerIndex], heroes[targetIndex]);
							command.execute();
							break;
							
						case "CURAJA":
							command = new curajaCommand(heroes[healerIndex], heroes[targetIndex]);
							command.execute();
							break;
							
						default:
							System.out.println(heroes[healerIndex].getName() + "doesn't know this spell (remember to type the spell name in CAPITAL LETTERS!).");
							
					}
					break;
					
				case 2:
					for(int i = 0; i < 4; i++) {
						System.out.println(heroes[i].getName() + ":\n" + heroes[i].getHitPoints() + "/" + heroes[i].getMaxHitPoints() + "HP\n" + heroes[i].getMagicPoints() + "/" + heroes[i].getMaxMagicPoints() + "MP\n");
					}
					break;
					
				case 3:
					System.out.println("Everyone can use these spells:\nCURE: heals 10HP, costs 5MP\nCURA: heals 20HP, costs 10MP\nCURASA: heals 30HP, costs 15MP\nCURAGA: heals 40HP, costs 20MP\nCURAJA: heals 50HP, costs 25MP\n");
					break;
					
				case 4:
					System.out.println("And so their quest began.\n\nAs the four Warriors of Light,\nthey felt overwhelmed by\nthe great task destiny had\nplaced before them.\n\nThey did not even know the\ntrue significance of the four\ncrystals they held in their hands...\n\nThe crystals that once,\nlong ago, held a light that\nshone so brilliantly.\n\nThe time for their journey had come.\n\nThe time to cast off the veil of\ndarkness and bring the world\nonce more into light...\n\n(Yes, that's a Final Fantasy reference)\n\n(Also don't worry, the four heroes went to a shop and bought enough Elixir to replenish their MP)");
					break;
					
				default:
					System.out.println("Option not available.");
			}
		}
		
	}

}
