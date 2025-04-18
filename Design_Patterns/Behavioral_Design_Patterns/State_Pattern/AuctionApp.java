public class AuctionApp {
  public static void main(String[] args) {
    var auction = new Auction();
    auction.startAuction();
    auction.placeBid();

    auction.startAuction();

    auction.closeAuction();
    auction.placeBid();

    auction.closeAuction();
  }
}

interface AuctionState {

  void startAuction(Auction auction);
  void closeAuction(Auction auction);
  void placeBid();

}

class AuctionStartedState implements AuctionState {

  @Override
  public void startAuction(Auction auction) {
    System.out.println("Auction already started");
  }

  @Override
  public void closeAuction(Auction auction) {
    auction.setState(new AuctionClosedState());
    System.out.println("Auction closed");
  }

  @Override
  public void placeBid() {
    System.out.println("Bid placed");
  }

}

class AuctionClosedState implements AuctionState {

  @Override
  public void startAuction(Auction auction) {
    auction.setState(new AuctionStartedState());
    System.out.println("Auction started");
  }

  @Override
  public void closeAuction(Auction auction) {
    System.out.println("Auction already closed");
  }

  @Override
  public void placeBid() {
    System.out.println("Bid not placed because auction is closed");
  }

}

class Auction {
  
  private AuctionState state;

  public Auction() {
    this.state = new AuctionClosedState();
  }

  public void startAuction() {
    state.startAuction(this);
  }

  public void closeAuction() {
    state.closeAuction(this);
  }

  public void placeBid() {
    state.placeBid();
  }

  public void setState(AuctionState state) {
    this.state = state;
  }
}