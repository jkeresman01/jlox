package com.keresman.jlox;

import java.util.List;

public interface JloxCallable {
    int arity();

    Object call(Interpreter interpreter, List<Object> arguments);
}
