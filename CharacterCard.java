
public class CharacterCard implements Card {
	
	public final CARDNAME type;	
	public final String name;
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
	

	

}

