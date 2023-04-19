import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    private List<Composer> composers;

    public MemComposerDao() {
        this.composers = new ArrayList<>();
        // create a default list of five composer objects
        this.composers.add(new Composer(1, "John Smith", "Baroque"));
        this.composers.add(new Composer(2, "Sarah Johnson", "Classical"));
        this.composers.add(new Composer(3, "Michael Davis", "Romantic"));
        this.composers.add(new Composer(4, "Jennifer Williams", "Romantic"));
        this.composers.add(new Composer(5, "David Brown", "Impressionist"));
    }

    @Override
    public List<Composer> findAll() {
        return this.composers;
    }

    @Override
    public Composer findBy(Integer id) {
        for (Composer composer : this.composers) {
            if (composer.getId().equals(id)) {
                return composer;
            }
        }
        return null;
    }

    @Override
    public void insert(Composer composer) {
        this.composers.add(composer);
    }
}
