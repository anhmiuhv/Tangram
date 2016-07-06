package builder.view;


import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SplashS extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4274966295587173717L;

	/**
	 * Create the panel.
	 */
	public SplashS() {
		
		JLabel lblKabasuji = new JLabel("KABASUJI BUILDER");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("SansSerif", Font.PLAIN, 100));
		
		JLabel lblNewLabel = new JLabel("GROUP:Patroclus");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		
		JLabel lblNewLabel_1 = new JLabel("Jingwei Shen, Xinyuan Wang, Kezheng Dai, Linh Hoang, Junbo Chen");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblKabasuji, GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addComponent(lblKabasuji, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
