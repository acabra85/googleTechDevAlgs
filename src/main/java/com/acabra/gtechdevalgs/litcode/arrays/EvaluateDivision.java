package com.acabra.gtechdevalgs.litcode.arrays;

import java.util.*;

public class EvaluateDivision {

    /**
     *
     * @param equations Array of pairs <x, y> representing the x/y in the equation
     * @param values Array of corresponding results to the equations
     * @param queries Array of pairs representing the questions to be solved
     * @return an array representing the solutions to the queries if not posible for a given query answer -1.0.
     */
    public double[] evaluateDivision(String[][] equations, double[] values, String[][] queries) {
        double[] answers = new double[queries.length];
        Map<String, Equation> solutions = new HashMap<>();
        Map<String, Set<Equation>> queryDividend = new HashMap<>();
        Map<String, Set<Equation>> queryDivisor= new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            Equation equation = new Equation(equations[i][0], equations[i][1], values[i]);
            Equation revEquation = equation.reverse();
            solutions.putIfAbsent(equation.id, equation);
            solutions.putIfAbsent(revEquation.id, revEquation);

            addIfAbsent(queryDividend, equation, true);
            addIfAbsent(queryDivisor, equation, false);
            addIfAbsent(queryDividend, revEquation, true);
            addIfAbsent(queryDivisor, revEquation, false);

            Stack<Equation> merge = merge(equation, solutions, queryDividend, queryDivisor);
            while (!merge.isEmpty()) {
                Equation iEq = merge.pop();
                merge.addAll(merge(iEq, solutions, queryDividend, queryDivisor));
            }
        }

        for (int i = 0; i<answers.length ;i++) {
            String varA = queries[i][0];
            String varB = queries[i][1];
            String key = varA +"/"+ varB;
            Equation equation = solutions.get(key);
            if (null != equation) { //look for the straight answer
                answers[i] = equation.res;
            } else {
                String revKey = varB + "/" + varA;
                Equation revEquation = solutions.get(revKey);
                if (null != revEquation) { //look for the inverse of the query
                    answers[i] = 1.0 / revEquation.res;
                } else {
                    answers[i] = lookForAnswer(varA, queryDividend, varB, queryDivisor);
                }
            }
        }
        return answers;
    }

    private Stack<Equation> merge(Equation equation, Map<String, Equation> equations, Map<String, Set<Equation>> queryDividend, Map<String, Set<Equation>> queryDivisor) {
        Set<Equation> newAdded1 = new HashSet<>();

        //A/B mult */A -> */B  Get equations with other.divisor equal to equation.dividend
        Iterator<Equation> iter1 = queryDivisor.get(equation.dividend).iterator();
        while (iter1.hasNext()) {
            Equation next = iter1.next();
            if (!next.equals(equation)) {
                Equation iEq = new Equation(next.dividend, equation.divisor, equation.res*next.res);
                if (equations.get(iEq.id) == null) {
                    equations.put(iEq.id, iEq);
                    Equation iRevEq = addInverse(iEq, equations);
                    newAdded1.add(iEq);
                    newAdded1.add(iRevEq);
                }
            }
        }

        for (Equation equation1 : newAdded1) {
            addIfAbsent(queryDividend, equation1, true);
            addIfAbsent(queryDivisor, equation1, false);
        }

        Set<Equation> newAdded2 = new HashSet<>();

        //A/B mult B/* -> A/* Get equations with other.dividend equal to equation.divisor
        Iterator<Equation> iter2 = queryDividend.get(equation.divisor).iterator();
        while (iter2.hasNext()) {
            Equation next = iter2.next();
            if (!next.equals(equation)) {
                Equation iEq = new Equation(equation.dividend, next.divisor, next.res*equation.res);
                if (equations.get(iEq.id) == null) {
                    equations.put(iEq.id, iEq);
                    Equation iRevEq = addInverse(iEq, equations);
                    newAdded2.add(iEq);
                    newAdded2.add(iRevEq);
                }
            }
        }

        for (Equation equation1 : newAdded2) {
            addIfAbsent(queryDividend, equation1, true);
            addIfAbsent(queryDivisor, equation1, false);
        }
        Set<Equation> newAdded3 = new HashSet<>();

        // A/B div */B -> A/*
        Iterator<Equation> iter3 = queryDivisor.get(equation.divisor).iterator();
        while (iter3.hasNext()) {
            Equation next = iter3.next();
            if (!next.equals(equation)) {
                Equation iEq = new Equation(equation.dividend, next.dividend, equation.res/next.res);
                if (equations.get(iEq.id) == null) {
                    equations.put(iEq.id, iEq);
                    Equation iRevEq = addInverse(iEq, equations);
                    newAdded3.add(iEq);
                    newAdded3.add(iRevEq);
                }
            }
        }
        for (Equation equation1 : newAdded3) {
            addIfAbsent(queryDividend, equation1, true);
            addIfAbsent(queryDivisor, equation1, false);
        }
        Set<Equation> newAdded4 = new HashSet<>();

        //A/B div A/* -> */B
        Iterator<Equation> iter4 = queryDividend.get(equation.dividend).iterator();
        while (iter4.hasNext()) {
            Equation next = iter4.next();
            if(!next.equals(equation)) {
                Equation iEq = new Equation(next.divisor, equation.divisor, equation.res/next.res);
                if (equations.get(iEq.id) == null) {
                    equations.put(iEq.id, iEq);
                    Equation iRevEq = addInverse(iEq, equations);
                    newAdded4.add(iEq);
                    newAdded4.add(iRevEq);
                }
            }
        }
        for (Equation equation1 : newAdded4) {
            addIfAbsent(queryDividend, equation1, true);
            addIfAbsent(queryDivisor, equation1, false);
        }
        newAdded1.addAll(newAdded2);
        newAdded1.addAll(newAdded3);
        newAdded1.addAll(newAdded4);
        Stack<Equation> stack = new Stack<>();
        stack.addAll(newAdded1);
        return stack;
     }

    private Equation addInverse(Equation iEq, Map<String, Equation> equations) {
        Equation reverse = iEq.reverse();
        equations.put(reverse.id, reverse);
        return reverse;
    }

    private double lookForAnswer(String dividend, Map<String, Set<Equation>> dividends, String divisor, Map<String, Set<Equation>> divisors) {
        if (dividend.equals(divisor) && (null != dividends.get(dividend) || null != divisors.get(divisor))) { //if the two variables are equal and i have equations stored for that value
            return 1.0;
        }
        return -1.0;
    }

    private void addIfAbsent(Map<String, Set<Equation>> map, Equation eq, boolean dividend) {
        String key = dividend ? eq.dividend : eq.divisor;
        Set<Equation> equations = map.get(key);
        if (equations == null) {
            equations = new TreeSet<>();
            map.put(key, equations);
        }
        equations.add(eq);
    }

    public static class Equation implements Comparable<Equation> {
        final String dividend;
        final String divisor;
        final double res;
        final String id;

        public Equation(String dividend, String divisor, double res) {
            this.dividend = dividend;
            this.divisor = divisor;
            this.res = res;
            this.id = dividend +"/"+ divisor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Equation equation = (Equation) o;
            return Double.compare(equation.res, res) == 0 &&
                    Objects.equals(dividend, equation.dividend) &&
                    Objects.equals(divisor, equation.divisor) &&
                    Objects.equals(id, equation.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dividend, divisor, res, id);
        }

        public Equation reverse() {
            return new Equation(divisor, dividend, 1.0/res);
        }

        @Override
        public int compareTo(Equation o) {
            return o.id.compareTo(this.id);
        }
    }
}
