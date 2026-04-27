package com.keresman.jlox;

import java.util.List;
import java.util.Map;

class JloxClass implements JloxCallable {

    final String name;
    final JloxClass superclass;
    private final Map<String, JloxFunction> methods;

    JloxClass(String name, JloxClass superclass, Map<String, JloxFunction> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
        JloxFunction initalizer = findMethod("init");

        if (initalizer == null) {
            return 0;
        }

        return initalizer.arity();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        JloxInstance jloxInstance = new JloxInstance(this);

        JloxFunction initalizer = findMethod("init");
        if (initalizer != null) {
            initalizer.bind(jloxInstance).call(interpreter, arguments);
        }

        return jloxInstance;
    }

    JloxFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
        }

        return null;
    }
}
