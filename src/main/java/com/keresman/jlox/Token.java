package com.keresman.jlox;

record Token(
        TokenType tokenType,
        String lexeme,
        Object literal,
        int line
) {
}
