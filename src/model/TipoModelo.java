package model;

public enum TipoModelo {
    MASERATI("MC20"),
    TOYOTA("Corolla", "Camry", "Yaris","RAV4"),
    HONDA("Civic", "Accord", "CR-V"),
    FORD("F-150", "Mustang", "Explorer"),
    CHEVROLET("Silverado", "Suburban", "Tahoe"),
    GM("Cadillac", "Chevrolet", "Buick", "GMC"),
    NISSAN("Sentra", "Altima", "Maxima", "Rogue","350Z"),
    HYUNDAI("Elantra", "Sonata", "Tucson", "Santa Fe","Azera","HB20"),
    VOLKSWAGEN("Jetta", "Passat", "Tiguan", "Touareg"),
    AUDI("A3 Sedan", "A4", "A6", "A8", "Q7"),
    BMW("3 Series", "5 Series", "7 Series","X3", "X5"),
    MERCEDES("C-Class", "E-Class", "S-Class","GLA","GLE"),
    PORSCHE("Boxster", "Cayman","Cayenne", "Panamera", "Macan"),
    LEXUS("ES", "GX", "IS", "RC"),
    MINI("Cooper", "Clubman", "Countryman", "Paceman"),
    FIAT("500", "Panda", "Punto", "500X","UNO");
    
    private final String[] modelos;

    TipoModelo(String... modelos) {
        this.modelos = modelos;
    }
    
    public boolean ehModeloValido(String model) {
        for (String validModel : modelos) {
            if (validModel.equalsIgnoreCase(model)) {
                return true;
            }
        }
        return false;
    }
}
