import javax.inject {
    inject
}

shared class Something() {
    inject shared variable SomethingElse? fieldInjected = null;

    //inject shared void incompleteInjection(String foo) {}

    variable SomethingElse? methodInjected = null;

    inject shared void injectCeylonObject(SomethingElse obj) {
        print("``obj`` field injected");
        methodInjected = obj;
    }

    shared String message() {
        assert(exists it=methodInjected);
        assert(exists it2=fieldInjected);
        return "methodInjected: ``it``\n " +
                "fieldInjected: ``it2``";
    }
}