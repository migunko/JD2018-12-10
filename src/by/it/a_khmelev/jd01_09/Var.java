package by.it.a_khmelev.jd01_09;


abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

    static Var createVar(String operand) {
        operand=operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        //TODO Replace errors
        System.err.println("Переменная "+operand+" не определена");
        return null;
    }
}
