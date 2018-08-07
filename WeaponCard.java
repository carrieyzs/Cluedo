import java.util.ArrayList;
import java.util.List;

public class WeaponCard implements Card{
	private List<Card> weaponcards;
	public final CARDNAME type;	
	public final String name;
	private final String cardtypename = "WeaponCard";
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

	//@Override
	public void addCards() {
		// TODO Auto-generated method stub
		if(this.weaponcards==null)
			this.weaponcards = new ArrayList<Card>();
		for(WeaponCard.CARDNAME c: WeaponCard.CARDNAME.values()) {
			weaponcards.add(new WeaponCard(c,cardtypename));
		}
		
	}

	//@Override
	public List<Card> getRoomCardList() {
		// TODO Auto-generated method stub
		return weaponcards;
	}
	@Override
	public String toString() {
		return name +":" + type;
	}

	}
