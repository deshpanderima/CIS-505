public class Composer {

    private int id;
    private String name;
    private String genre;

    // Default constructor
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    // Argument constructor
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Accessor methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Composer:\n" +
                "ID: " + id +
                "\nName: " + name +
                "\nGenre: " + genre;
    }
}
