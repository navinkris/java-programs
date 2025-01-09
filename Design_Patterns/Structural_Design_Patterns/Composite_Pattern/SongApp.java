
import java.util.ArrayList;
import java.util.List;

public class SongApp {
  public static void main(String[] args) {
    var a = new Note('A');
    var b = new Note('B');
    var c = new Note('C');
    var d = new Note('D');
    var e = new Note('E');
    var f = new Note('F');
    var g = new Note('G');

    var doReMe = new Song();

    doReMe.addNote(c);
    doReMe.addNote(d);
    doReMe.addNote(e);
    doReMe.addNote(c);
    doReMe.addNote(e);
    doReMe.addNote(c);
    doReMe.addNote(e);

    doReMe.play();

  }
}

interface MusicalItem {
  void play();
}

class Note implements MusicalItem{
  
  private final char value;

  public Note(char value) {
    this.value = value;
  }

  @Override
  public void play() {
    System.out.println(value);
  }
}

class Song implements MusicalItem{
  private final List<Note> notes = new ArrayList<>();

  public void addNote(Note note) {
    notes.add(note);
  }

  public List<Note> getNotes() {
    return notes;
  }

  @Override
  public void play() {
    notes.forEach(MusicalItem::play);
  }
}
