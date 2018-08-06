import java.util.HashSet;
import java.util.Set;

public class Player {
	private Square location; //location of square where player is at
	public final String characterName;//which token the player is using to play
	public final int playerId;//to keep track of player 
	public boolean suggestion;
	public boolean accusation;
	private boolean playing; //is the player playing or is out 
	private Set<Card> cards; //the cards the player will have in hand
	
	
public Player(Square loc, String name, int id){
	this.location = loc;
	this.characterName = name;
	this.playerId = id;
	this.cards = new HashSet<Card>();
	this.suggestion = false;
	this.accusation = false;
	this.playing = true;
}
//setters
public void setLocation(Square loc) {
	this.location = loc;
}
public void setPlaying(boolean playing) {
	this.playing = playing;
}
//gets the location of the player(returns the square the player is currently occupying)
public Square getLocation() {
	return location;
}
public void addCard (Card card) {
	cards.add(card);
}
public boolean isPlaying() {
	return playing;
}

public Set<Card> cardsInHand() {
	return cards;
}
}



