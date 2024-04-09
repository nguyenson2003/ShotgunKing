package model.card;

import model.Gameplay;

public class testCard extends Card {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    boolean isBuffCard() {
        return false;
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        super.actionAfterWhiteAction(gp);
    }
}
