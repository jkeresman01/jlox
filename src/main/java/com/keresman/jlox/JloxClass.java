package com.keresman.jlox;

import java.util.List;

class JloxClass implements JloxCallable{
    final String name;

    JloxClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        JloxInstance jloxInstance = new JloxInstance(this);
        return jloxInstance;
    }
}
