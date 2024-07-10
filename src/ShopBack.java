//package game;


public class ShopBack {

    private Item[] items = new Item[8];
    private int itemCount = 0;
    private Player user;

    public ShopBack(Player user){

        this.user = user;

    }

    public Boolean buyItem(Item item){

        if(user.getGold()>=item.getPrice()){
        	items[itemCount] = item;
        	itemCount ++;
            return true;
        }
        else{
            System.out.println("Not enough gold");
            return false;
        }

    }

    private Boolean checkGold(Item item){

        if(user.getGold()>=item.getPrice()) return true;
        return false;

    }

    private Boolean checkSpace(){

        if(items.length==0) return true;
        else return false;

    }
}


