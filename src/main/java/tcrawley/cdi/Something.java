package tcrawley.cdi;

import javax.inject.Inject;

public class Something {
    @Inject
    public Something(SomethingElse x) {
        this.constructorInjected = x;
    }

    @Inject
    void injectMethod(SomethingElse methodInjected) {
        this.methodInjected = methodInjected;
    }

    public String message() {
        return "constructorInjected: " + this.constructorInjected +
                "\n methodInjected: " + this.methodInjected +
                "\n fieldInjected: " + this.fieldInjected;
    }

    private SomethingElse constructorInjected;
    private SomethingElse methodInjected;
    @Inject
    private SomethingElse fieldInjected;
}
