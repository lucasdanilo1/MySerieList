package SerieList;

import SerieBuilder.Serie;
import SerieBuilder.Status;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="serielist")
public class SerieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Titulo")
    String title;
    @Column(name = "Score")
    private int score;
    @Column(name = "Progresso")
    private int progress;
    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "AdicionadoEm")
    LocalDate adicionadoEm = LocalDate.now();
    @ManyToOne
    private Serie serie;

    public SerieList(){
    }

    public SerieList(Serie serie, Status status) {
        this.serie = serie;
        if (status == Status.COMPLETED) {
            this.progress = serie.getTotalEpisodes();
        }
        this.title = serie.getTitle();
        this.status = status;
    }

    public void setProgress(int progress) throws Exception {
        if(progress > serie.getTotalEpisodes()){
            throw new Exception();
        }else{
            this.progress = progress;
        }
    }

    public void setScore(int score) throws Exception {
        if(score > 10 || score < 0){
            throw new Exception();
        } else{
            this.score = score;
        }
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return serie.getTitle();
    }

    @Override
    public String toString() {
        return "Titulo: " + serie.getTitle() +" Status:" + this.status + " Score: " + this.score + " Progress: " +this.progress;
    }
}
