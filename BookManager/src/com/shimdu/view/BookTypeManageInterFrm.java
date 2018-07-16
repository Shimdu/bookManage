package com.shimdu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.shimdu.dao.BookDao;
import com.shimdu.dao.BookTypeDao;
import com.shimdu.model.BookType;
import com.shimdu.util.DbUtil;
import com.shimdu.util.StringUtil;
import javax.swing.ImageIcon;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	private JTextArea bookTypeDescTxt;
	private JTextField s_bookTypeNameTxt;
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 489, 595);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		label.setFont(new Font("黑体", Font.PLAIN, 12));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search.png")));
		button.setFont(new Font("黑体", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button)))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 12));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 12));
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u4FEE  \u6539");
		btnNewButton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/updater.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 12));
		
		JButton btnNewButton_1 = new JButton("\u5220  \u9664");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/delete.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeDescTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressd(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(36);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(93);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(209);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		bookTypeNameTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

		this.fillTable(new BookType());
	}
	
	protected void bookTypeDeleteActionPerformed(ActionEvent evt) {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				boolean flag = bookDao.existBookByBookTypeId(con, id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别！");
					return;
				}
				int deleteNum = bookTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new BookType());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
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
	}

	private void bookTypeUpdateActionEvent(ActionEvent evt) {
		String id = idTxt.getText();
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookTypeDao.update(con, bookType);
			if (modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new BookType());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败！");
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
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookTypeTableMousePressd(MouseEvent evt) {
		int row = bookTypeTable.getSelectedRow();
		idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0); //设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, bookType);
			while(rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
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
	 * 图书类别搜索点击事件
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		String s_bookTypeName = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
