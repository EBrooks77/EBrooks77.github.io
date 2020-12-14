# Software Design and Engineering

The artifact I selected for the software engineering and design prompt was the final project from one of my earliest classes. This project use java to create a slideshow of vacation locations as part of a travel business’ marketing strategy. I chose this piece of code because it was simple, straightforward, and met its base purpose but could be improved to do all of those things better. 

The first change was a small one. The original coloring of the slideshow boxes was a dark blue that did not mix well with the images being presented. I updated this color to better suit the marketing focus of the slideshow. 

The second change is more involved. I added in a timer function to swap to the next slide after 6 seconds even if the next button is not clicked. This allows for cycling through the slides without having to interact. This also serves a marketing purpose by showing more vacation destinations without any action needed.

There may be more work needed to make sure that the timer functionality is consistent. I found while working on this that sometimes the timing gets messed up if you click to the next slide in the middle of the timer. For example, if you manually change the slide during the 4th second, it might change again 2 seconds later. More work will need to be done to iron out that issue. Looping the slideshow back to the first slide would be another improvement. That way the automation of the slides doesn’t simply shorten the time that the slides are being viewed.

[Slide Show zip](https://github.com/EBrooks77/EBrooks77.github.io/blob/main/ErinBrooks_CS499_SoftwareDesignEngineering/ErinBrooks_CS499_Slideshow.zip)


```java

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.CYAN);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Hot_spring_pool_Ciater_Spa_Resort_pool_side_2.JPG") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Le_Meridien_Limassol_Spa_&_Resort,_Cyprus.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/RO_BH_Lotus_Therm_Spa_&_Luxury_Resort_Baile_Felix_(6).jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Spa_Resort_Hawaiians._Dance_of_Fula_Girls_A.JPG") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/The_Sentosa_Resort_and_Spa,_Sentosa,_Aug_06.JPG") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Ciater Spa Resort.</font> <br>Relax in the hot spring pools.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Le Meridien Limassol Spa & Resort.</font> <br>Ocean views and flowing water help to relax you during your getaway stay.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Lotus Spa & Resort.</font> <br>Many options to soak and relax during your luxury stay.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Hawaiian Spa Resport.</font> <br>Enjoy a local show during this trip away.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Sentosa Resort and Spa.</font> <br>A rainforest getaway with breathtaking views.</body></html>";
		}
		return text;
	}

	/**
	* Method to run slideshow on a timer
	*/
	private void playSlideshow() {
		setInterval(goNext(), 6000);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}

```
