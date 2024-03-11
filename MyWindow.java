import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clockLabel;
    private Font font=new Font("",Font.BOLD,20);

    //setting window for clock building
    MyWindow(){
        super.setTitle("My Clock");
        super.setSize(400,300);
        super.setLocation(200,50);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createGUI();
        this.startClock();
        super.setVisible(true);
    }

    public void createGUI()
    {
        heading=new JLabel("My Clock");
        clockLabel=new JLabel("clock");
        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }


    //for clock creation
    public void startClock() {
//        Timer timer=new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    String dateTime=new Date().toString();
//                    clockLabel.setText(dateTime);
//            }
//        }) ;
//          timer.start();
//    }




        //another way to generate digital clock
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String dateTime=new Date().toLocaleString();
//                clockLabel.setText(dateTime);
//            }
//        });
//        timer.start();



//        Timer timer=new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date date=new Date();
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
//                String dateTime=simpleDateFormat.format(date);
//                clockLabel.setText(dateTime);
//            }
//        });
//        timer.start();



        //By using thread perform operation
        Thread t=new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                        String dateTime = simpleDateFormat.format(date);
                        clockLabel.setText(dateTime);

                        Thread.currentThread().sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}

