package com.zc.design.observe;

public abstract class Observe {

    private Subject subject;

    public Observe(Subject subject){
        this.subject = subject;
    }

    public abstract void changed();

}
