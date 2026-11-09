public class PlayList {
    public static void main(String[] args) {
        CircleList playlist = new CircleList();
    
        playlist.add("Stayin Alive");
        playlist.add("Le Freak");
        playlist.add("Jive Talkin");
    
        // Move the cursor so "Stayin Alive" is immediately after it.
        playlist.advance();
        playlist.advance();
    
        System.out.println("Removing: " + playlist.back());
        playlist.remove();
        playlist.add("Disco Inferno");
    
        System.out.println("Replacement: " + playlist.back());
    }
}
