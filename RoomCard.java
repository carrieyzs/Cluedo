import java.util.ArrayList;
import java.util.List;

public class RoomCard implements Card{
	private List<Card> roomcards;
	public final RoomName type;	
	public final String name;
	private final String cardtypename = "RoomCard";
	public RoomCard(RoomName cardtype, String name) {
		this.type = cardtype;
		this.name = name;
	}
public enum RoomName{
KITCHEN, BALLROOM, CONSERVATORY, DINING_ROOM, BILLIARD_ROOM, LIBRARY, LOUNGE, HALL, STUDY;
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
	if(this.roomcards==null)
		this.roomcards = new ArrayList<Card>();
		for(RoomCard.RoomName roomname: RoomCard.RoomName.values()) {
		roomcards.add(new RoomCard(roomname,cardtypename));
	}
}
public List<Card> getRoomCardList(){
	return roomcards;
}
@Override
public String toString() {
	return name +":" + type;
}

}

