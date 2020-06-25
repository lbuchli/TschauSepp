package ch.lukas.ts.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import ch.lukas.ts.model.Card;

public class CardListCellRenderer implements ListCellRenderer<Card> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Card> list, Card value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		InputStream file = getClass().getClassLoader().getResourceAsStream(value.getImageFileName());
		if (file == null) return new JLabel(value.getImageFileName()); // TODO make this unnecessary
		try {
			BufferedImage image = ImageIO.read(file);
			if (isSelected) {
				// TODO shift up
			}
			JLabel result = new JLabel(new ImageIcon(image), JLabel.LEFT);
			//int width = list.getPreferredSize().width/list.getComponentCount();
			result.setPreferredSize(new Dimension(75, 200));
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Could not read card image");
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				throw new RuntimeException("Could not close stream");
			}
		}
	}

}
