package com.keresman.jlox;

import java.util.HashMap;
import java.util.Map;

class JloxInstance {

    private final Map<String, Object> fields = new HashMap<>();
    private JloxClass jloxClass;

    public JloxInstance(JloxClass jloxClass) {
        this.jloxClass = jloxClass;
    }

    @Override
    public String toString() {
        return jloxClass.name + " instance";
    }

    public Object get(Token name) {
        if (fields.containsKey(name.lexeme())) {
            return fields.get(name.lexeme());
        }

        JloxFunction method = jloxClass.findMethod(name.lexeme());
        if (method != null) return method.bind(this);

        throw new RuntimeError(name,
                "Undefined property '" + name.lexeme() + "'.");
    }

    void set(Token name, Object value) {
        fields.put(name.lexeme(), value);
    }
}
