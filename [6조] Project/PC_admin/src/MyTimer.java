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

      // 시간을 감소시키는 함수
      void decHour() {
            if(time.getHour() > 0) {
                  time.setHour(time.getHour()-1);
                  time.setMinute(59);
                  time.setSecond(59);
            } else {
                  stop();            
            }

      }

      // 분을 감소시키는 함수
      void decMinute() {
            if(time.getMinute() > 0) {
                  time.setMinute(time.getMinute()-1);
                  time.setSecond(59);
            } else {
                  // 분이 0이라서 감소시킬수 없다면 시간을 감소시킨다.
                  decHour();
            }
      }

      // 초를 감소시키는 함수
      void decSecond() {
            if(time.getSecond() > 0) {
                  time.setSecond(time.getSecond()-1);
            } else {
                  // 초가 0이라서 감소시킬수 없다면 분을 감소시킨다.
                  decMinute();
            }
      }
      
      // 시간을 증가 시키는 함수
      void incHour() {
            if(time.getHour() < 3) {
                  time.setHour(time.getHour() + 1);
                  time.setMinute(00);
                  time.setSecond(00);
            } else {
                  stop();            
            }
      }

      // 분을 증가 시키는 함수
      void incMinute() {
            if(time.getMinute() < 60) {
                  time.setMinute(time.getMinute() + 1);
                  time.setSecond(00);
            } else {
                  // 분이 0이라서 감소시킬수 없다면 시간을 감소시킨다.
                  incHour();
            }
      }

      // 초를 증가 시키는 함수
      void incSecond() {
            if(time.getSecond() < 60) {
                  time.setSecond(time.getSecond() + 1);
            } else {
                  // 초가 0이라서 감소시킬수 없다면 분을 감소시킨다.
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