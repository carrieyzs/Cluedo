
public class Card {

	public final CARDTYPE type;	
	public final String name;
    public Card(CARDTYPE cardtype, String name) {
		this.type = cardtype;
		this.name = name;
	}

	

	public enum CARDTYPE {
		CHARACTER, WEAPON, ROOM;
	}
}

