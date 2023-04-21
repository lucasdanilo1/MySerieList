package SerieBuilder;

public class InvalidScoreException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidScoreException(String mensagem) {
        super(mensagem);
    }
}
