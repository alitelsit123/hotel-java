/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import backend.DB;
import backend.Input;
import interfaces.HomeSlider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.Timer;
import threads.Threads;
import views.Main;

public class CtrlHome implements HomeSlider{
    private final Main home;
    public CtrlHome(Main home){
        this.home = home;
    }
    public void add(Input input){
        mirrorComponents();
        home.getLblAdmin().setText(input.get("nama").toUpperCase());
        home.setLocationRelativeTo(null);
    }
    public void logout(){
        Threads.get("Main").exit();
        Threads.view("Login");
    }
    public void slideKamar(){
        setBtnSubMenu(home.getBtnKamar().getText());
        paneSubMenuSlide(home.getBtnKamar().getText());
    }
    public void inOut(){
        setBtnSubMenu(home.getBtnInOut().getText());
        paneSubMenuSlide(home.getBtnInOut().getText());
    }
    public void back(){
        setBtnSubMenu();
        paneMenuSlide();
    }
    public void roomServices(){
        setBtnSubMenu(home.getBtnRoomServices().getText());
        paneSubMenuSlide(home.getBtnRoomServices().getText());
    }
    public void layanan(){
        setBtnSubMenu(home.getBtnLayanan().getText());
        paneSubMenuSlide(home.getBtnLayanan().getText());
    }
    public void bukuTamu(){
        setBtnSubMenu(home.getBtnBukuTamu().getText());
        paneSubMenuSlide(home.getBtnBukuTamu().getText());
    }
    public void userAdmin(){
        setBtnSubMenu(home.getBtnUsersAdmin().getText());
        paneSubMenuSlide(home.getBtnUsersAdmin().getText());
    }
    public void laporan(){
        setBtnSubMenu(home.getBtnLaporan().getText());
        paneSubMenuSlide(home.getBtnLaporan().getText());
    }
    public void perusahaan(){
        setBtnSubMenu(home.getBtnPerusahaan().getText());
        paneSubMenuSlide(home.getBtnPerusahaan().getText());
    }
    public void mirrorComponents()
    {
        try {
            ResultSet result = DB.getInstance().get("SELECT nama_hotel FROM detail WHERE id_hotel = '534A-5B28-6079-45BD-86AD-195E-AF3B-E427'");        
            while(result.next())
            {
                home.getHotelName().setText(result.getString("nama_hotel"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneMenuWidth = home.getPaneMenu().getPreferredSize().width;
        paneSubMenuWidth = home.getPaneSubMenu().getPreferredSize().width;
        paneX = home.getPaneSubMenu().getX();
        
        menuComponent = new HashMap<>();
        setBtnMenus();
        
        subMenuComponent = new JButton[]{
            home.getBtnSubMenu0(), home.getBtnSubMenu1(), home.getBtnSubMenu2(), home.getBtnSubMenu3(), home.getBtnSubMenu4(), home.getBtnSubMenu5()};
        setBtnSubMenu();
    }
    private void setBtnMenus()
    {
        getMenuComponent().put("Check In/Out", new String[]
            /*  TEXT MENU CHECK IN OUT  */
            {"Check In", "Check Out", "Tamu In House"}
        );
        
        getMenuComponent().put("Room Services", new String[]
            /*  TEXT MENU LAYANAN   */
            {"Pesan Menu"}
        
        );
        
        getMenuComponent().put("Kamar", new String[]    
            /*  TEXT KAMAR  */
            {"Lihat Kamar", "Lihat Tipe Kamar"}
        );
        
        getMenuComponent().put("Layanan", new String[]    
            /*  TEXT LAYANAN    */
            {"Lihat Layanan", "Tambah Layanan"}
        );
        
        getMenuComponent().put("Buku Tamu", new String[]    
            /*  TEXT Buku Tamu    */
            {"Lihat Tamu", "Tambah Tamu"}
        );
        
        getMenuComponent().put("Users", new String[]    
            /*  TEXT User Admin    */
            {"Lihat Users"}
        );
        
        getMenuComponent().put("Laporan", new String[]    
            /*  TEXT Laporan    */
            {"Transaksi Kamar", "Transaksi Layanan"}
        );
        
        getMenuComponent().put("Hotel", new String[]    
            /*  TEXT Perusahaan    */
            {"Detail Hotel"}
        );
        
    }
    private void setBtnSubMenu(String menu)
    {
        int subMenuCount = 0;
        for(String subMenuList: getMenuComponent().get(menu))
        {
            getSubMenuComponent()[subMenuCount].setText(subMenuList);
            getSubMenuComponent()[subMenuCount].setVisible(true);
            subMenuCount++;
        }
    }
    private void setBtnSubMenu()
    {
        for(JButton subMenuEntry:getSubMenuComponent()){
            subMenuEntry.setText("Null");
            subMenuEntry.setVisible(false);
        }
    }
    
    private void paneMenuSlide()
    {
        home.getLblPath().setText("Menu");
        paneMenuWidth = home.getPaneMenu().getWidth();
        paneSubMenuWidth = home.getPaneSubMenu().getWidth();
        paneX = home.getPaneSubMenu().getX();
        delay = new Timer(1000/100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.getPaneMenu().setBounds(0, 0, paneMenuWidth+=1090/10, home.getPaneMenu().getHeight());
                home.getPaneSubMenu().setBounds(paneX+=1090/10, 0, paneSubMenuWidth-=1090/10, home.getPaneSubMenu().getHeight());
                if(getPaneX() == 1090) 
                    getDelay().stop();
                
            }
        });
        getDelay().start();
    }
    
    private void paneSubMenuSlide(String menu)
    {
        home.getLblPath().setText(home.getLblPath().getText() + " - " + menu);
        delay = new Timer(1000/100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    home.getPaneMenu().setBounds(0, 0, paneMenuWidth-=1090/10, home.getPaneMenu().getHeight());
                    home.getPaneSubMenu().setBounds(paneX-=1090/10, 0, paneSubMenuWidth+=1090/10, home.getPaneSubMenu().getHeight());
                if(getPaneX() == 0)
                    getDelay().stop();
            }
        });
        getDelay().start();
    }
    
    private Timer delay;
    private int paneMenuWidth;
    private int paneSubMenuWidth;
    private int paneX;
    private Map<String, String[]> menuComponent;
    private JButton[] subMenuComponent;

    /**
     * @return the delay
     */
    public Timer getDelay() {
        return delay;
    }

    /**
     * @return the paneMenuWidth
     */
    public int getPaneMenuWidth() {
        return paneMenuWidth;
    }

    /**
     * @return the paneSubMenuWidth
     */
    public int getPaneSubMenuWidth() {
        return paneSubMenuWidth;
    }

    /**
     * @return the paneX
     */
    public int getPaneX() {
        return paneX;
    }

    /**
     * @return the menuComponent
     */
    public Map<String, String[]> getMenuComponent() {
        return menuComponent;
    }

    /**
     * @return the subMenuComponent
     */
    public JButton[] getSubMenuComponent() {
        return subMenuComponent;
    }

    @Override
    public void slide0() {
        Threads.view(home.getBtnSubMenu0().getText());
    }
    @Override
    public void slide1() {
        Threads.view(home.getBtnSubMenu1().getText());
    }
    @Override
    public void slide2() {
        Threads.view(home.getBtnSubMenu2().getText());
    }
    @Override
    public void slide3() {
        Threads.view(home.getBtnSubMenu3().getText());
    }
    @Override
    public void slide4() {
        Threads.view(home.getBtnSubMenu4().getText());
    }
    @Override
    public void slide5() {
        Threads.view(home.getBtnSubMenu5().getText());
    }
}
