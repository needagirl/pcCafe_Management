import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyTimer {
	  JButton outputLabel = null;
      MyTime time;
      Timer swingTimer = null;
      MyTimer(int hour, int min, int sec) {
            time = new MyTime(hour, min, sec);
      }
      String getTime() {
            return time.toString();
      }

      void descStart() {
    	  this.swingTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	            decSecond();
	            outputLabel.setText(time.toString());
			}
    	  });
    	  this.swingTimer.start();
      }
      void incStart() {
    	  this.swingTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	            incSecond();
	            outputLabel.setText(time.toString());
			}
    	  });
    	  this.swingTimer.start();
      }

      // �ð��� ���ҽ�Ű�� �Լ�
      void decHour() {
            if(time.getHour() > 0) {
                  time.setHour(time.getHour()-1);
                  time.setMinute(59);
                  time.setSecond(59);
            } else {
                  stop();            
            }

      }

      // ���� ���ҽ�Ű�� �Լ�
      void decMinute() {
            if(time.getMinute() > 0) {
                  time.setMinute(time.getMinute()-1);
                  time.setSecond(59);
            } else {
                  // ���� 0�̶� ���ҽ�ų�� ���ٸ� �ð��� ���ҽ�Ų��.
                  decHour();
            }
      }

      // �ʸ� ���ҽ�Ű�� �Լ�
      void decSecond() {
            if(time.getSecond() > 0) {
                  time.setSecond(time.getSecond()-1);
            } else {
                  // �ʰ� 0�̶� ���ҽ�ų�� ���ٸ� ���� ���ҽ�Ų��.
                  decMinute();
            }
      }
      
      // �ð��� ���� ��Ű�� �Լ�
      void incHour() {
            if(time.getHour() < 3) {
                  time.setHour(time.getHour() + 1);
                  time.setMinute(00);
                  time.setSecond(00);
            } else {
                  stop();            
            }
      }

      // ���� ���� ��Ű�� �Լ�
      void incMinute() {
            if(time.getMinute() < 60) {
                  time.setMinute(time.getMinute() + 1);
                  time.setSecond(00);
            } else {
                  // ���� 0�̶� ���ҽ�ų�� ���ٸ� �ð��� ���ҽ�Ų��.
                  incHour();
            }
      }

      // �ʸ� ���� ��Ű�� �Լ�
      void incSecond() {
            if(time.getSecond() < 60) {
                  time.setSecond(time.getSecond() + 1);
            } else {
                  // �ʰ� 0�̶� ���ҽ�ų�� ���ٸ� ���� ���ҽ�Ų��.
                  incMinute();
            }
      }

      void reset() {
            // time = new MyTime();
            time.setHour(0);
            time.setMinute(0);
            time.setSecond(0);
      }

      void stop() {
    	  System.exit(0);
            
      }
      public void setOutputLabel(JButton button) {
    	  this.outputLabel = button;
      }
}

class MyTime {
      int hour=0;
      int minute=0;
      int second=0;

      MyTime() {
            this(0,0,0);
      }

      MyTime(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
      }

      int getHour() { return hour; }
      int getMinute() { return minute; }
      int getSecond() { return second; }

      void setHour(int hour) {
            if(hour >= 0) {
                  this.hour = hour;
            }      
      }
      void setMinute(int minute) {
            if(minute >= 0 || minute < 60) {
                  this.minute = minute;
            }      
      }
      void setSecond(int second) {
            if(second >= 0 || second < 60) {
                  this.second = second;
            }            
      }

      public String toString() {
            String tmp = "";
            tmp += (hour < 10)? "0"+hour : ""+ hour;
            tmp += ":";
            tmp += (minute < 10)? "0"+minute : ""+ minute;
            tmp += ":";
            tmp += (second < 10)? "0"+second : ""+ second;

            return tmp;
      }
}