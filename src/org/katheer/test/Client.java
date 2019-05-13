package org.katheer.test;

import org.katheer.bean.User;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Client {
    public static void main(String[] args) {
        /*
        Operators:
        ----------
        1. Arithmetic Operator
        ----------------------
        +
        -
        *
        / or div
        % or mod

        2. Logical Operator
        -------------------
        && or and
        || or or
        !  or not

        3. Relational or Comparision operator
        -------------------------------------
        == or eq
        != or ne
        <  or lt
        <= or le
        >  or gt
        >= or ge

        4. Conditional or Ternary Operator
        ----------------------------------
        Expr1 ? Expr2 : Expr3;

        5. Type Operator
        ----------------
        Used to specify Type or Class Name in SpEL expression.

        T(Class_Name)

        6. Safe Navigation Operator
        ---------------------------
        Used to avoid NullPointerException when accessing properties of an
        object.

        property_ref_name?.method_name_or_var_name
         */

        ExpressionParser parser = new SpelExpressionParser();

        //1. Arithmetic Operator
        System.out.println("Arithmetic Operation:");
        System.out.println("---------------------");
        System.out.println("Addition    : " + parser.parseExpression(
                "10 + 10").getValue());
        System.out.println("Subtraction : " + parser.parseExpression(
                "20 - 10").getValue());
        System.out.println("Multiply    : " + parser.parseExpression(
                "20 * 2").getValue());
        System.out.println("Division    : " + parser.parseExpression(
                "20 / 4").getValue());
        System.out.println("Division    : " + parser.parseExpression(
                "20 div 4").getValue());
        System.out.println("Modulo      : " + parser.parseExpression(
                "20 % 3").getValue());
        System.out.println("Modulo      : " + parser.parseExpression(
                "20 mod 3").getValue());
        System.out.println();

        System.out.println("Logical Operator:");
        System.out.println("-----------------");
        System.out.println("&&      : " + parser.parseExpression(
                "false && true").getValue());
        System.out.println("||      : " + parser.parseExpression(
                "false || true").getValue());
        System.out.println("!       : " + parser.parseExpression(
                "!true").getValue());
        System.out.println();

        System.out.println("Relational Operator");
        System.out.println("-------------------");
        System.out.println("< or lt     : " + parser.parseExpression(
                "10 < 5").getValue());
        System.out.println("<= or le    : " + parser.parseExpression(
                "10 <= 10").getValue());
        System.out.println("> or gt     : " + parser.parseExpression(
                "10 > 20").getValue());
        System.out.println(">= or ge    : " + parser.parseExpression(
                "10 >= 9").getValue());
        System.out.println("== or eq    : " + parser.parseExpression(
                "10 == 10").getValue());
        System.out.println("!= or ne    : " + parser.parseExpression(
                "10 != 10").getValue());
        System.out.println();

        System.out.println("Ternary Operator");
        System.out.println("----------------");
        System.out.println(parser.parseExpression(
                "10 == 10 ? 'condition true' : 'condition false'").getValue());
        System.out.println();

        System.out.println("Type Operator");
        System.out.println("-------------");
        System.out.println(parser.parseExpression("T(Thread).MIN_PRIORITY").getValue());
        System.out.println(parser.parseExpression("T(Math).max(10, 30)").getValue());
        System.out.println();

        System.out.println("Safe Navigation Operator");
        System.out.println("------------------------");
        User user = new User();
        user.setName("Abdul Katheer");
        //user.pwd is null right now
        StandardEvaluationContext context = new StandardEvaluationContext(user);
        System.out.println(parser.parseExpression(
                "name?.toUpperCase()").getValue(context));
        System.out.println(parser.parseExpression(
                "pwd?.length()").getValue(context));
    }
}
