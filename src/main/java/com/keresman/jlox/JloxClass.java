package com.keresman.jlox;

class JloxClass {
    final String name;

    JloxClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
