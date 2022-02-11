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
        StringBuilder builder = new StringBuilder();
        builder.append("Architecture Check Failure for ")
                .append(elementType)
                .append(":")
                .append("\n");
        builder.append("Check: ").append(check).append("\n");
        builder.append("expected: ").append(exptected).append("\n");
        builder.append("actual: ").append(acutal).append("\n");
        return builder.toString();
    }
}
