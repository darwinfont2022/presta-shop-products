package com.darwinfont.presta_products.domain.prestaShop;

public enum Resource {
    CATEGORIES("categories");
    private final String resource;

    Resource(String resource){
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public static Resource fromString(String input) {
        for (Resource rse: Resource.values()) {
            if (rse.resource.equals(input))
                return rse;
        }

        throw new IllegalArgumentException("Resource not found " + input);
    }
}
