public class RoomCard implements Card{
	public final RoomName type;	
	public final String name;
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

}

