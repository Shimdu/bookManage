package com.shimdu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.shimdu.dao.AuthorDao;
import com.shimdu.dao.BookDao;
import com.shimdu.dao.BookTypeDao;
import com.shimdu.model.Author;
import com.shimdu.model.Book;
import com.shimdu.model.BookType;
import com.shimdu.util.DbUtil;
import com.shimdu.util.StringUtil;
import javax.swing.ImageIcon;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField priceTxt;
	private JComboBox bookTypeJcb;
	private JComboBox authorJcb;
	private JTextArea bookDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao;
	private BookDao bookDao;
	private AuthorDao authorDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 582, 475);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label.setFont(new Font("黑体", Font.PLAIN, 12));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F5C  \u8005\uFF1A");
		label_1.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		label_2.setFont(new Font("黑体", Font.PLAIN, 12));
		
		bookDescTxt = new JTextArea();
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_3.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		label_4.setFont(new Font("黑体", Font.PLAIN, 12));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setFont(new Font("黑体", Font.PLAIN, 12));
		
		authorJcb = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)
							.addGap(393))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_2)
								.addGap(501))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(bookDescTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_3)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGap(62)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(label_1)
												.addGap(18)
												.addComponent(authorJcb, 0, 145, Short.MAX_VALUE)))))
								.addGap(76)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(36)
					.addComponent(label_2)
					.addGap(18)
					.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

		fillBookType();
		fillAuthor();
		
	}
	
	/**
	 * 出书画图书类别下拉框
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			while(rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void fillAuthor() {
		Connection con = null;
		Author author = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = authorDao.list(con, new Author());
			while(rs.next()) {
				author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				this.authorJcb.addItem(author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 图书字段添加处理
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName=this.bookNameTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		String price=this.priceTxt.getText();
		
		BookType bookType = (BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId= bookType.getId();
		Author author = (Author)authorJcb.getSelectedItem();
		int authorId = author.getId();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(bookDesc)) {
			JOptionPane.showMessageDialog(null, "图书描述不能为空！");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		Book book = new Book(bookName, authorId, Float.parseFloat(price), bookDesc, bookTypeId);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.add(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
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
		this.resetValue();
	}

	private void resetValue() {
		this.bookNameTxt.setText("");
		this.bookDescTxt.setText("");
		this.priceTxt.setText("");
		
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
		if(this.authorJcb.getItemCount()>0) {
			this.authorJcb.setSelectedIndex(0);
		}
	}
}
