package by.it.dziomin.calculator.vars;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.Localization;
import by.it.dziomin.calculator.Localizer;
import by.it.dziomin.calculator.Patterns;
import by.it.dziomin.calculator.interfaces.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IVar, IAdd, IDiv, IMul, ISub {

    private static Map<String, Var> vars = new HashMap<>();

    public static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (vars.containsKey(operand))
            return vars.get(operand);
        return null;
    }

    public static void saveVar(String nameVar, Var value) {
        vars.put(nameVar, value);
    }

    public abstract String toString();

    public boolean isScalar() {
        return false;
    }

    public boolean isVector() {
        return false;
    }

    public boolean isMatrix() {
        return false;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(Localizer.getBundle().getString(Localization.ADD_ERROR));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(Localizer.getBundle().getString(Localization.SUB_ERROR));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(Localizer.getBundle().getString(Localization.MUL_ERROR));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(Localizer.getBundle().getString(Localization.DIV_ERROR));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
