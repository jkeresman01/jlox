package com.keresman.jlox;

class JloxInstance {

    private JloxClass jloxClass;

    public JloxInstance(JloxClass jloxClass) {
        this.jloxClass = jloxClass;
    }

    @Override
    public String toString() {
        return jloxClass.name + " instance";
    }
}
