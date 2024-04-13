package view.gameplay;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;
import model.card.Card;
import view.general.General;
import view.general.TRoom;

import javax.swing.*;
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
    private JPanel buffPanel = new JPanel();
    private JPanel debuffPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel centerCenterPanel = new JPanel();
    private InfoAmmoBlackKing infoAmmoBlackKing = new InfoAmmoBlackKing();
    private InfoWhitePieceView infoWhitePieceView = new InfoWhitePieceView();
    private InfoBlackKingView infoBlackKingView=new InfoBlackKingView();
    private ChoiceCardView choiceCardView;
    private InfoCardView info = new InfoCardView();
    public GameplayRoom(){
        ins = this;
        gameplay = new Gameplay();
        boardView = new BoardView(gameplay);
        choiceCardView = new ChoiceCardView(gameplay,gameplay.makeTwoChoiceOfCard());
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
//        centerCenterPanel.add(boardView);
        centerCenterPanel.add(choiceCardView);
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
                this.setVisible(false);
                this.setVisible(true);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
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
        info.setLocation(getMousePosition());
    }
    public void reloadInfoBlackPiece(){
        infoBlackKingView.reload();
        infoAmmoBlackKing.reload();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        buffPanel.setPreferredSize(new Dimension(getWidth()/5,0));
        debuffPanel.setPreferredSize(new Dimension(getWidth()/5,0));
        infoBlackKingView.setPreferredSize(new Dimension(getWidth()/10,0));
        infoWhitePieceView.setPreferredSize(new Dimension(getWidth()/10,0));
        infoAmmoBlackKing.setPreferredSize(new Dimension(0,getWidth()/10));
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
