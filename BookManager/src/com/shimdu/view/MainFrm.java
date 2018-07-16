package com.shimdu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setFont(new Font("仿宋", Font.PLAIN, 12));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Settings.png")));
		menu.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Categories.png")));
		menu_2.setFont(new Font("宋体", Font.PLAIN, 12));
		menu.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		menuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_2.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Maintenance.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_2.add(mntmNewMenuItem_1);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/library.png")));
		menu_3.setFont(new Font("宋体", Font.PLAIN, 12));
		menu.add(menu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		menuItem_2.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/Maintenance.png")));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookManageInterFrm bookManageInterFrm = new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		menuItem_3.setFont(new Font("宋体", Font.PLAIN, 12));
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0) {
					dispose();
				}
			}
		});
		menuItem.setFont(new Font("宋体", Font.PLAIN, 12));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/star.png")));
		menu_1.setFont(new Font("宋体", Font.PLAIN, 12));
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5F00\u53D1\u8005\u56E2\u961F");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/team.png")));
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShimduInterFrm java1234InterFrm = new ShimduInterFrm();
				java1234InterFrm.setVisible(true);
				table.add(java1234InterFrm);
			}
		});
		menu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
