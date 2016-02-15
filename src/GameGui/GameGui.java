package gui2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class GameGui extends JFrame {
	private String BGImage = new String("BGImage.png");
	private JPanel mainMenu;
	private JPanel contentPane;
	private JPanel joinGameMenu;
	private JTextField serverAddresTxt;
	private final Action joinGame = new SwingAction();
	private CardLayout cl = new CardLayout();
	private final Action createGame = new SwingAction_1();
	private final Action BTMM = new BackToMainMenu();
	private JTextField nickname;
	private JTextField nicknameTxt1;
	private JPanel menuBG;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGui frame = new GameGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl);
		/*
		 * Main menu
		 */
		mainMenu = new ImagePanel(BGImage);
		contentPane.add(mainMenu, "main_menu");
		GridBagLayout gbl_mainMenu = new GridBagLayout();
		
		mainMenu.setLayout(gbl_mainMenu);
		JButton joinGameBtn = new JButton("Join Game");
		joinGameBtn.setAction(joinGame);
		joinGameBtn.setPreferredSize(new Dimension(200, 100));
		GridBagConstraints gbc_joinGameBtn = new GridBagConstraints();
		gbc_joinGameBtn.insets = new Insets(0, 0, 5, 0);
		gbc_joinGameBtn.gridx = 0;
		gbc_joinGameBtn.gridy = 0;
		mainMenu.add(joinGameBtn, gbc_joinGameBtn);
		
		JButton createGameBtn = new JButton("Create Game");
		createGameBtn.setAction(createGame);
		createGameBtn.setPreferredSize(new Dimension(200, 50));
		GridBagConstraints gbc_createGameBtn = new GridBagConstraints();
		gbc_createGameBtn.gridx = 0;
		gbc_createGameBtn.gridy = 1;
		mainMenu.add(createGameBtn, gbc_createGameBtn);
		/*
		 * Join Game menu
		 */
		joinGameMenu = new ImagePanel(BGImage);
		contentPane.add(joinGameMenu, "join");
		GridBagLayout gbl_joinGameMenu = new GridBagLayout();
		joinGameMenu.setLayout(gbl_joinGameMenu);
		
		nickname = new JTextField("Nickname");
		nickname.setPreferredSize(new Dimension(400, 30));
		GridBagConstraints gbc_nickname = new GridBagConstraints();
		gbc_nickname.insets = new Insets(0, 0, 5, 0);
		gbc_nickname.fill = GridBagConstraints.HORIZONTAL;
		gbc_nickname.gridx = 0;
		gbc_nickname.gridy = 0;
		joinGameMenu.add(nickname, gbc_nickname);
		nickname.setColumns(10);
		
		serverAddresTxt = new JTextField("Server Address");
		serverAddresTxt.setPreferredSize(new Dimension(400, 30));
		GridBagConstraints gbc_serverAddresTxt = new GridBagConstraints();
		gbc_serverAddresTxt.insets = new Insets(0, 0, 5, 0);
		gbc_serverAddresTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_serverAddresTxt.gridx = 0;
		gbc_serverAddresTxt.gridy = 1;
		joinGameMenu.add(serverAddresTxt, gbc_serverAddresTxt);
		serverAddresTxt.setColumns(10);
		
		JButton joinGameBtn1 = new JButton("New button");
		joinGameBtn1.setPreferredSize(new Dimension(200, 50));
		GridBagConstraints gbc_joinGameBtn1 = new GridBagConstraints();
		gbc_joinGameBtn1.insets = new Insets(0, 0, 5, 0);
		gbc_joinGameBtn1.gridx = 0;
		gbc_joinGameBtn1.gridy = 2;
		joinGameMenu.add(joinGameBtn1, gbc_joinGameBtn1);
		
		JButton backToMainMenuBtn = new JButton("New button");
		backToMainMenuBtn.setAction(BTMM);
		GridBagConstraints gbc_backToMainMenuBtn = new GridBagConstraints();
		gbc_backToMainMenuBtn.gridx = 0;
		gbc_backToMainMenuBtn.gridy = 3;
		joinGameMenu.add(backToMainMenuBtn, gbc_backToMainMenuBtn);
		/*
		 * Create Game menu
		 */
		JPanel createGameMenu = new ImagePanel(BGImage);
		contentPane.add(createGameMenu, "create");
		GridBagLayout gridBagLayout = new GridBagLayout();
		createGameMenu.setLayout(gridBagLayout);
		
		nicknameTxt1 = new JTextField("Nickname");
		nicknameTxt1.setPreferredSize(new Dimension(400, 30));
		GridBagConstraints gbc_nicknameTxt1 = new GridBagConstraints();
		gbc_nicknameTxt1.insets = new Insets(0, 0, 5, 0);
		gbc_nicknameTxt1.fill = GridBagConstraints.HORIZONTAL;
		gbc_nicknameTxt1.gridx = 0;
		gbc_nicknameTxt1.gridy = 0;
		createGameMenu.add(nicknameTxt1, gbc_nicknameTxt1);
		nicknameTxt1.setColumns(10);
		
		JButton createGameBtn1 = new JButton("Create game");
		createGameBtn1.setPreferredSize(new Dimension(200, 50));
		GridBagConstraints gbc_createGameBtn1 = new GridBagConstraints();
		gbc_createGameBtn1.insets = new Insets(0, 0, 5, 0);
		gbc_createGameBtn1.gridx = 0;
		gbc_createGameBtn1.gridy = 1;
		createGameMenu.add(createGameBtn1, gbc_createGameBtn1);
		
		JButton backToMainMenuBtn1 = new JButton("New button");
		backToMainMenuBtn1.setAction(BTMM);
		GridBagConstraints gbc_backToMainMenuBtn1 = new GridBagConstraints();
		gbc_backToMainMenuBtn1.insets = new Insets(0, 0, 5, 0);
		gbc_backToMainMenuBtn1.gridx = 0;
		gbc_backToMainMenuBtn1.gridy = 2;
		createGameMenu.add(backToMainMenuBtn1, gbc_backToMainMenuBtn1);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Join Game");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		cl.show(contentPane, "join");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Create Game");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(contentPane, "create");
		}
	}
	private class BackToMainMenu extends AbstractAction {
		public BackToMainMenu() {
			putValue(NAME, "Bak to Main Menu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(contentPane, "main_menu");
		}
	}
}
