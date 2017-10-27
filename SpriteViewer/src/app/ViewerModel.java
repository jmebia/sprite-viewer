package app;

import javafx.scene.image.Image;

public class ViewerModel {

    private Image spritesheet;
    private int spriteHeight;
    private int spriteWidth;
    private int animColumns;
    private int animRow;

    private int currentIndex;
    private int maxIndex;
    private int minIndex;

    public ViewerModel(Image image, int h, int w, int col, int row) {
        spritesheet = image;
        spriteHeight = h;
        spriteWidth = w;
        animColumns = col;
        animRow = row;

        minIndex = 0;
        maxIndex = col - 1;
        currentIndex = minIndex;
    }

    public Image getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(Image spritesheet) {
        this.spritesheet = spritesheet;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public int getAnimColumns() {
        return animColumns;
    }

    public void setAnimColumns(int animColumns) {
        this.animColumns = animColumns;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int getAnimRow() {
        return animRow;
    }

    public void setAnimRow(int animRow) {
        this.animRow = animRow;
    }
}
