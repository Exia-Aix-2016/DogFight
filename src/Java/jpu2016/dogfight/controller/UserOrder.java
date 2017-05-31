package jpu2016.dogfight.controller;

public class UserOrder implements IUserOrder {
    private int player;

    public UserOrder(int player, Order order){

    }

    @Override
    public Order getOrder(){
        return Order.DOWN;
    }

    @Override
    public int getPlayer() {
        return player;
    }
}
