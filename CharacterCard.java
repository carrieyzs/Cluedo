import java.util.ArrayList;
import java.util.List;

public class CharacterCard implements Card {
	private List<Card> playercards;
	public final CARDNAME type;	
	public final String name;
	private final String cardtypename = "CharacterCard";
	public CharacterCard(CARDNAME cardtype, String name) {
		this.type = cardtype;
		this.name = name;
	}



	public enum CARDNAME {
		MISS_SCARLETT, COLONEL_MUSTARD, MRS_WHITE, MR_GREEN, MRS_PEACOCK, PROFESSOR_PLUM ;

	}
	
	//@Override
	public String getCardName() {
		// TODO Auto-generated method stub
		return this.name;
		
	}

	//@Override
	public Card getCardType() {
		// TODO Auto-generated method stub
		return this;
	}

	//@Override
	public void addCards() {
		if(this.playercards==null)
			this.playercards = new ArrayList<Card>();
		for(CharacterCard.CARDNAME character: CharacterCard.CARDNAME.values()) {
			playercards.add(new CharacterCard(character,cardtypename));
		}
		
	}

	//@Override
	public List<Card> getRoomCardList() {
		// TODO Auto-generated method stub
		
			return playercards;
		
	}
	@Override
	public String toString() {
		return name +":" + type;
	}
	
}

