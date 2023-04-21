package SerieBuilder;

import javax.persistence.*;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private int totalEpisodes;
    private int Aired;

    public Serie(){
    }

    public Serie(String title, String diretor, int episodes, int Aired) {
            this.title = title;
            this.director = diretor;
            this.totalEpisodes = episodes;
            this.Aired = Aired;
    }
    public int getAired() {
        return Aired;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }
    public int getTotalEpisodes() {
        return totalEpisodes;
    }


}
