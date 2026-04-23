package com.keresman.jlox;

abstract class Expr {

    static class Binary extends Expr {
        final Expr left;
        final TokenType operator;
        final Expr right;

        Binary(Expr left, TokenType operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }
    }
}
