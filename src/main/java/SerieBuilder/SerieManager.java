package SerieBuilder;

public abstract class SerieManager {

    private int progress;
    private int score;
    public Status status;


    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
    public void setProgress(int progress) {
        this.progress = progress;
    }
    public int getProgress() {
        return progress;
    }

    public void setScore(int score) {
        if(score > 10 || score < 0) {
            throw new InvalidScoreException("Nota deve estar entre 0 e 10");
        }else {
            this.score = score;
        }
    }
    public int getScore() {
        return score;
    }
}
