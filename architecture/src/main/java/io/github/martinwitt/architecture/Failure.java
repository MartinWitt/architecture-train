package io.github.martinwitt.architecture;

public class Failure {

    private String elementType;
    private String check;
    private String exptected;
    private String acutal;

    public Failure(String elementType, String check, String exptected, String acutal) {
        this.elementType = elementType;
        this.check = check;
        this.exptected = exptected;
        this.acutal = acutal;
        Architecture.raiseFailure(this);
    }

    @Override
    public String toString() {
        return String.format(
                "Architecture Check Failure for %s:%nCheck: %s%nexpected: %s%nactual: %s%n",
                elementType, check, exptected, acutal);
    }
}
