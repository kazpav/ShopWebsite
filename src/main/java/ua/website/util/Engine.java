package ua.website.util;

import java.awt.image.BufferedImage;

/**
 * This class works with images by cropping them
 * making them square images
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
public class Engine {

	/** {@code BufferedImage} object that will come from client*/
	private final BufferedImage old;

	/**
	 *  {@code BufferedImage} object this class will work with
	 *  based on {@link Engine#old} object
	 */
	private final BufferedImage present;

	/** Image's axis of abscissas*/
	private final int oldX;

	/** Image's axis of ordinates*/
	private final int oldY;

	/**
	 * Keeps image's orientation strategy.
	 * True for vertical, false for horizontal
	 */
	private final boolean isVerticalStrategy;

	/**
	 * This constructor takes {@code BufferedImage} object as param,
	 * gets it's X and Y axis and sets {@link Engine#present}
	 * @param old image from clien
	 */
	public Engine(BufferedImage old) {
		this.old = old;
		oldX = old.getWidth();
		oldY = old.getHeight();
		isVerticalStrategy = oldY > oldX;
		present = new BufferedImage(oldX > oldY ? oldY : oldX, oldX > oldY ? oldY : oldX, old.getType());
	}

	/**
	 * This method crops the image
	 * depending on it's orientation
	 * @return cropped image
	 */
	public BufferedImage crop(){
		if(isVerticalStrategy)werticalCrop();
		else horizontalCrop();
		return present;
	}

	/**
	 * This method crops images with vertical strategy
	 */
	private void werticalCrop(){
		final int offset = (oldY - oldX) / 2;
		for(int x = 0; x < present.getHeight(); x++){
			for(int y = 0; y < present.getWidth(); y++){
				present.setRGB(x, y, old.getRGB(x, y+offset));
			}
		}
	}

	/**
	 * This method crops images with horizontal strategy
	 */
	private void horizontalCrop(){
		final int offset = (oldX - oldY) / 2;
		for(int x = 0; x < present.getHeight(); x++){
			for(int y = 0; y < present.getWidth(); y++){
				present.setRGB(x, y, old.getRGB(x+offset, y));
			}
		}
	}
}