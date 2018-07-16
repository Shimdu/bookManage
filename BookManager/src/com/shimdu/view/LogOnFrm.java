package com.shimdu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.shimdu.dao.UserDao;
import com.shimdu.model.User;
import com.shimdu.util.DbUtil;
import com.shimdu.util.StringUtil;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/books.png")));
		label.setFont(new Font("仿宋", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 12));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("黑体", Font.PLAIN, 12));
		userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(passwordTxt))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(115))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置窗口居中
		this.setLocationRelativeTo(null);
	}

	//登录事件处理
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(userName,password);
		Connection con = null;
		try {
			con=dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser!=null) {
				dispose();
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名密码错误！");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
