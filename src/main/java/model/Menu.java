package model;

public enum Menu{

    Steam_Rice(161.00),
    Soya_Dum_Biryani(220.00),
    Veg_Pulao(161.00),
    Mix_Veg_Pulao(161.00),
    Jeera_Pulao(161.00),
    Matka_Biryani_With_Raita(220.00),
    Hyderabadi_Biryani(220.00),
    Plain_Raita(102.00),
    Boondi_Raita(102.00),
    Mix_Veg_Raita(102.00),
    Jeera_Raita(102.00),
    Pineapple_Raita(102.00),
    Gulab_Jamun(60.00),
    Halwa(60.00);

    private double price;

    Menu(double price)
    {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
