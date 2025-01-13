public class VideoPlayer {

  private static final MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();

  public static void main(String[] args) {
    goToMovieLibrary();
    gotToFavoriteMovies();
  }

  private static void goToMovieLibrary() {
    System.out.println("Loading movie Library...");
    mediaPlayerProxy.playMedia();
  }

  private static void gotToFavoriteMovies() {
    System.out.println("Loading favorite movies...");
    mediaPlayerProxy.playMedia();
  }
}

interface MediaPlayer {
  void playMedia();
}

class MovieMediaPlayer implements MediaPlayer {
  
  public MovieMediaPlayer() {
    loadVideo();
  }

  @Override
  public void playMedia() {
    System.out.println("Playing video...");
  }

  private void loadVideo() {
    System.out.println("Loading up large video...");
  }
}

class MediaPlayerProxy implements MediaPlayer {

  private MovieMediaPlayer movieMediaPlayer;

  @Override
  public void playMedia() {
    if(movieMediaPlayer == null) {
      movieMediaPlayer = new MovieMediaPlayer();
    }
    movieMediaPlayer.playMedia();
  }
}
