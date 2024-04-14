package view.gameplay;

import model.*;
import model.card.Card;
import view.gameover.GameOverRoom;
import view.general.General;
import view.general.TRoom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GameplayRoom extends TRoom implements ComponentListener {
    private static GameplayRoom ins;

    public static GameplayRoom getIns() {
        return ins;
    }
    Gameplay gameplay;
    private BoardView boardView;
    private JLabel msgLabel =new JLabel();
    private ListCardView buffPanel;
    private ListCardView debuffPanel;
    private JPanel centerPanel = new JPanel();
    private JPanel centerCenterPanel = new JPanel();
    private InfoAmmoBlackKing infoAmmoBlackKing = new InfoAmmoBlackKing();
    private InfoWhitePieceView infoWhitePieceView = new InfoWhitePieceView();
    private InfoBlackKingView infoBlackKingView=new InfoBlackKingView();
    private ChoiceCardView choiceCardView ;
    private InfoCardView info = new InfoCardView();
    int floor = 1;
    public GameplayRoom(){
        ins = this;
        gameplay = new Gameplay();
        boardView = new BoardView(gameplay);
        buffPanel = new ListCardView(gameplay.getBuffCards(),true);
        debuffPanel = new ListCardView(gameplay.getDebuffCards(),false);
//        choiceCardView = new ChoiceCardView(gameplay.makeTwoChoiceOfCard());
        setBackground(General.DEFAULT_COLOR);
        setLayout(new BorderLayout());
        //mess
        {
            msgLabel.setPreferredSize(new Dimension(50,50));
            msgLabel.setHorizontalAlignment(JLabel.CENTER);
        }
        centerCenterPanel.setLayout(new BorderLayout());
        centerCenterPanel.setOpaque(false);
        centerCenterPanel.add(infoAmmoBlackKing,BorderLayout.NORTH);
        centerCenterPanel.add(boardView);
//        centerCenterPanel.add(choiceCardView);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(infoBlackKingView,BorderLayout.WEST);
        centerPanel.add(infoWhitePieceView,BorderLayout.EAST);
        centerPanel.add(centerCenterPanel,BorderLayout.CENTER);
        centerPanel.add(msgLabel,BorderLayout.SOUTH);
        this.add(info);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(buffPanel,BorderLayout.WEST);
        this.add(debuffPanel,BorderLayout.EAST);
        this.addComponentListener(this);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
//                this.setVisible(false);
//                this.setVisible(true);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
        buffPanel.reload();
        debuffPanel.reload();
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void showMsg(String msg) {
        msgLabel.setText(msg);
    }
    public void showInfoWhitePiece(WhitePiece p){
        infoWhitePieceView.showInfo(p);
    }
    public void reloadInfoWhitePiece(){
        infoWhitePieceView.reload();
    }
    public void hideInfoWhitePiece(){
        infoWhitePieceView.hideInfo();
    }
    public void showInfoBlackPiece(BlackKing p){
        infoBlackKingView.showInfo(p);
        infoAmmoBlackKing.showInfo(p);
    }
    public void showInfoCard(Card c){
        info.showInfoCard(c);
        info.setSize(400,200);
    }
    public void hideInfoCard(){
        info.hideInfoCard();
    }
    public void reloadPositionInfoCard(){
        Point p = getMousePosition();
        if(p==null)return;
        int x=p.x + 10,y=p.y+10;
        x = Math.min(x,this.getWidth()-info.getWidth());
        y = Math.min(y,this.getHeight()-info.getHeight());
        if(y<=p.y){
            y = p.y - info.getHeight();
        }
        info.setLocation(x,y);
    }
    public void reloadInfoBlackPiece(){
        infoBlackKingView.reload();
        infoAmmoBlackKing.reload();
    }
    public void endOneFloor(){
        System.out.println("test");
        hideInfoWhitePiece();
        if(gameplay.checkBlackWinGame()){
            new Thread(()->{
                for(PieceView pv : boardView.whitePieceViewList){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    pv.beDestroyed();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(floor==5)
                    General.getGeneralFrame().setRoom(new GameOverRoom(false));
                else
                    makeTwoChoice();

            }).start();
        }else {
            new Thread(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                General.getGeneralFrame().setRoom(new GameOverRoom(false));
            }).start();
        }
    }
    public void makeTwoChoice(){
        var p = gameplay.makeTwoChoiceOfCard();
        choiceCardView = new ChoiceCardView(p);
        centerCenterPanel.remove(boardView);
        centerCenterPanel.add(choiceCardView);
//        this.setVisible(false);
//        this.setVisible(true);
    }
    public void selectAChoice(Pair<Card,Card> p){
        gameplay.addAChoice(p);
        buffPanel.reload();
        debuffPanel.reload();
        gameplay = gameplay.clone();
        boardView = new BoardView(gameplay);
        centerCenterPanel.remove(choiceCardView);
        centerCenterPanel.add(boardView);
        hideInfoCard();
//        this.setVisible(false);
//        this.setVisible(true);
    }
    @Override
    public void componentResized(ComponentEvent e) {
        buffPanel.setPreferredSize(new Dimension(getWidth()/9,0));
        debuffPanel.setPreferredSize(new Dimension(getWidth()/9,0));
        infoBlackKingView.setPreferredSize(new Dimension(getWidth()/10,0));
        infoWhitePieceView.setPreferredSize(new Dimension(getWidth()/10,0));
        infoAmmoBlackKing.setPreferredSize(new Dimension(0,getWidth()/10));
        centerPanel.setBorder(new EmptyBorder(0,getWidth()/11,0,getWidth()/11));
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
