
public class WeaponCard implements Card{
	public final CARDNAME type;	
	public final String name;
	public WeaponCard(CARDNAME cardtype, String name) {
		this.type = cardtype;
		this.name = name;
	}
	public enum CARDNAME{
		CANDLESTICK, DAGGER, LEADPIPE, REVOLVER, ROPE, SPANNER;
		
		
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
