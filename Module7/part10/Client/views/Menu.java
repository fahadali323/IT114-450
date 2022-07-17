package Module7.part10.Client.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Module7.part10.Client.Card;
import Module7.part10.Client.ICardControls;

public class Menu extends JMenuBar{
    public Menu(ICardControls controls){
        JMenu roomsMenu = new JMenu("Rooms");
        JMenuItem roomsSearch = new JMenuItem("Search");
        roomsSearch.addActionListener((event) -> {
            controls.show(Card.ROOMS.name());
        });
        roomsMenu.add(roomsSearch);
        this.add(roomsMenu);
    }
}