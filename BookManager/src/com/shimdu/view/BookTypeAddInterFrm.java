package com.shimdu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.shimdu.dao.BookTypeDao;
import com.shimdu.model.BookType;
import com.shimdu.util.DbUtil;
import com.shimdu.util.StringUtil;
import javax.swing.ImageIcon;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 518, 374);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		button_1.setFont(new Font("黑体", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeNameTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(18)
									.addComponent(button_1))
								.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(45))
		);
		getContentPane().setLayout(groupLayout);
		
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		bookTypeNameTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	
	//图书类别添加事件处理
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection con =null;
		try {
			con = dbUtil.getCon();
			int n=bookTypeDao.add(con,bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	private void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
