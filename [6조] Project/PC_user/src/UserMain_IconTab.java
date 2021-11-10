import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserMain_IconTab extends JPanel {
	JPanel setBtns = new JPanel(new GridLayout(1,5,10,10));
	JButton chromeBtn = new JButton("CHROME");
	JButton twitterBtn = new JButton("TWITTER");
	JButton facebookBtn = new JButton("FACEBOOK");
	JButton instagramBtn = new JButton("INSTAGRAM");
	JButton youtubeBtn = new JButton("YOUTUBE");
	
	public UserMain_IconTab() {

		setLayout(new BorderLayout());

		add(setBtns);
		
		setBtns.add(chromeBtn);
		chromeBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		chromeBtn.setForeground(Color.WHITE);
		chromeBtn.setBackground(new Color(41, 140, 191));
		
		setBtns.add(twitterBtn);
		twitterBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		twitterBtn.setForeground(Color.WHITE);
		twitterBtn.setBackground(new Color(41, 140, 191));

		setBtns.add(facebookBtn);
		facebookBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		facebookBtn.setForeground(Color.WHITE);
		facebookBtn.setBackground(new Color(41, 140, 191));
		
		setBtns.add(instagramBtn);
		instagramBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		instagramBtn.setForeground(Color.WHITE);
		instagramBtn.setBackground(new Color(41, 140, 191));
		
		setBtns.add(youtubeBtn);
		youtubeBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
		youtubeBtn.setForeground(Color.WHITE);
		youtubeBtn.setBackground(new Color(41, 140, 191));
	
		youtubeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try { Desktop.getDesktop().browse(new URI("http://youtube.com/")); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} catch (URISyntaxException e) 
				{ e.printStackTrace(); 
				} 
			}

		});
		
		instagramBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try { Desktop.getDesktop().browse(new URI("http://instagram.com/")); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} catch (URISyntaxException e) 
				{ e.printStackTrace(); 
				} 
			}

		});
		
		facebookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try { Desktop.getDesktop().browse(new URI("http://facebook.com/")); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} catch (URISyntaxException e) 
				{ e.printStackTrace(); 
				} 
			}

		});

		twitterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try { Desktop.getDesktop().browse(new URI("http://twitter.com/")); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} catch (URISyntaxException e) 
				{ e.printStackTrace(); 
				} 
			}

		});

		chromeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try { Desktop.getDesktop().browse(new URI("http://chrome.com/")); 
				} catch (IOException e) {
					e.printStackTrace(); 
				} catch (URISyntaxException e) 
				{ e.printStackTrace(); 
				} 
			}

		});
			
	}
	
}