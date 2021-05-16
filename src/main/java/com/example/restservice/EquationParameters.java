package com.example.restservice;


public class EquationParameters {
    private int a;
    private int b;

    public EquationParameters(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public Equation createEquation()
    {
        Equation equation= new Equation(a, b);
        return equation;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + a;
        result = prime * result + b;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EquationParameters other = (EquationParameters) obj;
        if (a != other.a)
            return false;
        if (b != other.b)
            return false;
        return true;
    }
}
