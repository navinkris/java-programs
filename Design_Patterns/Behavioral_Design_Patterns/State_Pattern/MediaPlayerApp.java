public class MediaPlayerApp {
  public static void main(String[] args) {
    var mediaPlayer = new MediaPlayer();
    mediaPlayer.pressButton();
    mediaPlayer.pressButton();
  }
}

class MediaPlayer {
  private PlayerState state;

  public MediaPlayer() {
    this.state = new PausedState();
  }

  public void pressButton() {
    state.pressButton(this);
  }

  public void play() {
    System.out.println("Playing");
    System.out.println("Displaying pause icon");
  }

  public void pause() {
    System.out.println("Paused");
    System.out.println("Displaying play icon");
  }

  public void setState(PlayerState state) {
    this.state = state;
  }
}

interface PlayerState {
  void pressButton(MediaPlayer player);
}

class PausedState implements PlayerState {

  @Override
  public void pressButton(MediaPlayer player) {
    player.play();
    player.setState(new PlayingState());
  }

}

class PlayingState implements PlayerState {

  @Override
  public void pressButton(MediaPlayer player) {
    player.pause();
    player.setState(new PausedState());
  }

}
