
public class Playlist {

   

    static class Track {
        String title;
        String artist;
        float  duration;   // seconds

        Track(String title, String artist, float duration) {
            this.title    = title;
            this.artist   = artist;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return String.format("%-20s — %-18s (%.1fs)", title, artist, duration);
        }
    }

    static class Node {
        Track track;
        Node  prev;
        Node  next;

        Node(Track track) {
            this.track = track;
        }
    }

    /* ---------- playlist state ---------- */

    private Node head;
    private Node tail;
    private Node current;   // currently playing / selected track
    private int  count;

    public Playlist() {
        head = tail = current = null;
        count = 0;
    }

    /* ---------- add / remove ---------- */

    /** Append a track to the end of the playlist. O(1) thanks to `tail`. */
    public void append(Track t) {
        Node n = new Node(t);
        n.prev = tail;

        if (tail != null) tail.next = n;
        else              head = n;       // first node

        tail = n;

        if (current == null) current = n; // first track becomes current
        count++;
    }

    /** Unlink a node. Fixes up current/head/tail as needed. */
    public void remove(Node n) {
        if (n == null) return;

        if (n.prev != null) n.prev.next = n.next;
        else                head = n.next;

        if (n.next != null) n.next.prev = n.prev;
        else                tail = n.prev;

        // if we deleted the playing track, fall through to the next one,
        // or back to the previous if it was the last
        if (current == n)
            current = (n.next != null) ? n.next : n.prev;

        count--;
    }

    /** Remove by title — returns true if removed, false if not found. */
    public boolean removeByTitle(String title) {
        for (Node n = head; n != null; n = n.next) {
            if (n.track.title.equals(title)) {
                remove(n);
                return true;
            }
        }
        return false;
    }

    /* ---------- transport ---------- */

    public Track next() {
        if (current != null && current.next != null)
            current = current.next;
        return (current != null) ? current.track : null;
    }

    public Track prev() {
        if (current != null && current.prev != null)
            current = current.prev;
        return (current != null) ? current.track : null;
    }

    public Track getCurrent() {
        return (current != null) ? current.track : null;
    }

    public int size() {
        return count;
    }

    /* ---------- output / cleanup ---------- */

    public void print() {
        System.out.println("Playlist (" + count + " tracks):");
        for (Node n = head; n != null; n = n.next) {
            String marker = (n == current) ? ">" : " ";
            System.out.println("  " + marker + " " + n.track);
        }
    }

    /** In Java, the garbage collector frees the nodes; we just drop references. */
    public void clear() {
        head = tail = current = null;
        count = 0;
    }

    /* ---------- demo ---------- */

    public static void main(String[] args) {
        Playlist pl = new Playlist();

        pl.append(new Track("Intro",      "Nova",  12.5f));
        pl.append(new Track("Deep Water", "Nova", 213.0f));
        pl.append(new Track("Outro",      "Kite",  45.2f));

        pl.print();

        System.out.println("\n-- next --");
        Track t = pl.next();
        System.out.println("Now playing: " + t.title);

        System.out.println("\n-- remove \"Deep Water\" --");
        pl.removeByTitle("Deep Water");
        pl.print();

        System.out.println("\n-- prev --");
        t = pl.prev();
        System.out.println("Now playing: " + t.title);

        pl.clear();
    }
}