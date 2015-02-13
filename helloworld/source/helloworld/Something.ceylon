import javax.inject {
    inject, inject__FIELD
}

inject shared class Something(SomethingElse constructorInjected) {
    inject__FIELD shared variable SomethingElse? fieldInjected = null;

    //inject shared void incompleteInjection(String foo) {}

    variable SomethingElse? methodInjected = null;

    inject shared void injectCeylonObject(SomethingElse obj) {
        print("``obj`` method injected");
        methodInjected = obj;
    }

    shared String message() {
        assert(exists it=methodInjected);
        assert(exists it2=fieldInjected);
        return "contstructorInjected: ``constructorInjected``\n " +
                "methodInjected: ``it``\n " +
                "fieldInjected: ``it2``";
    }
}