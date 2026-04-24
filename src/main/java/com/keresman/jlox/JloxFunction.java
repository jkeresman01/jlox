package com.keresman.jlox;

import java.util.List;

class JloxFunction implements JloxCallable{

    private final Stmt.Function declaration;
    private final Environment closure;
    private boolean isInitalizer;


    JloxFunction(Stmt.Function declaration, Environment closure, boolean isInitalizer) {
        this.declaration = declaration;
        this.closure = closure;
        this.isInitalizer = isInitalizer;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    JloxFunction bind(JloxInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new JloxFunction(declaration, environment, isInitalizer);
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(closure);

        for (int i = 0; i < declaration.params.size(); ++i) {
            environment.define(
                    declaration.params.get(i).lexeme(),
                    arguments.get(i)
            );
        }

        try{
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            if (isInitalizer) {
                return closure.getAt(0, "this");
            }

            return returnValue.value;
        }

        if (isInitalizer) {
            return closure.getAt(0, "this");
        }

        return null;
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme() + ">";
    }
}
