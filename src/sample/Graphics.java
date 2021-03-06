/**
 * Graphics Class contains the logic related to the
 * visualisation of the cells. This class is called when the game
 * starts.
 *
 * @author Rudi André Dahle
 * @author Ginelle Ignacio
 * @author Olav Smevoll
 */
package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;


public class Graphics {

    //Data field
    protected GraphicsContext gc;
    private double cellHeight;
    private double cellWidth;
    private int xCell;
    private int yCell;
    private boolean shape = true;


    /**
     * Graphics' default constructor receives an
     * argument of the GraphicsContext's class to
     * drawGrid calls to the canvas area.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param gc Receives the content related to
     *           GraphicsContext
     */
    public Graphics (GraphicsContext gc){
        this.gc = gc;
    }


    /**
     * Draws the board with existing live cells for every loop
     * in a static board. Currently noo longer in use
     * because of the dynamic board.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param graphicsBoard Receives the value of the graphicBoard
     *                      in boolean 2D array
     */
    @Deprecated
    public void draw(boolean[][] graphicsBoard) {
        for(int x = 0; x < graphicsBoard.length; x++) {
            for(int y = 0; y < graphicsBoard[0].length; y++) {
                if (graphicsBoard[x][y]) {
                    gc.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }


    /**
     * Sets the value of shape
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param s Parameter receives a boolean value of shape
     */
    public void setShape(boolean s){
        this.shape = s;
    }


    /**
     * Method called to make the cells visible on the
     * dynamic board
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @param dynamicBoard Parameter receives a list within a list
     *                     and a boolean element of the dynamic board
     */
    public void drawDynamic(List<List<Boolean>> dynamicBoard){
        clearDynamicBoard();
        for(int x = 0; x < dynamicBoard.size(); x++){
            for(int y = 0; y < dynamicBoard.size(); y++){
                if(dynamicBoard.get(x).get(y)){
                    if(shape){
                        gc.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                    } else {
                        gc.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                    }
                }
            }
        }
    }


    /**
     * Method called to make a living or dead cell when the user draws
     * into the canvas area.
     *
     * @author Rudi Andre Dahle
     * @author Ginelle Ignacio
     * @author Olav Smevoll
     * @param dynamicBoard Parameter receives a list within a list
     *                     and a boolean element of the dynamic board
     */
    public void drawDynamicCell(List<List<Boolean>> dynamicBoard) {
        if (!dynamicBoard.get(xCell).get(yCell)) {
            dynamicBoard.get(xCell).set(yCell, true);
        } else {
            dynamicBoard.get(xCell).set(yCell, false);
            gc.clearRect(xCell * cellWidth, yCell * cellHeight, cellWidth, cellHeight);
        }
        drawDynamic(dynamicBoard);
    }


    /**
     * Clears the old static board before the next generation
     * is drawn. No longer in use because of the dynamic board.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param gameBoard receives the static game board as boolean
     *                  2D array.
     */
    @Deprecated
    public void clearBoard(boolean[][] gameBoard) {
        for(int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[0].length; y++) {
                if (gameBoard[x][y]) {
                    gc.clearRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }


    /**
     * Method called to clear the visuals of the dynamic board.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     */
    public void clearDynamicBoard(){
        gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
    }


    /**
     * Method called to drawGrid a cell when the user interacts with
     * the canvas area. This method is used together with the
     * static board.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param graphicsBoard Receives the value of the graphicBoard
     *                      in boolean 2D array
     */
    @Deprecated
    public void drawCell(boolean[][] graphicsBoard) {
        if (!graphicsBoard[xCell][yCell]) {
            graphicsBoard[xCell][yCell] = true;
        } else {
            graphicsBoard[xCell][yCell] = false;
            gc.clearRect(xCell * cellWidth, yCell * cellHeight, cellWidth, cellHeight);
        }
        draw(graphicsBoard);
    }


    /**
     * Computes the cell's x value when the user clicks
     * a cell in the canvas area.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param xCoord The coordinates in the canvas of the selected x-cell
     */
    public void setXCell(double xCoord){
        xCell = (int)Math.floor(xCoord/cellWidth);
    }


    /**
     * Computes the cell's y value when the user clicks
     * a cell in the canvas area.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param yCoord The coordinates in the canvas of the selected y-cell
     */
    public void setYCell(double yCoord){
        yCell = (int)Math.floor(yCoord/cellHeight);
    }


    /**
     * Gets the x value of a cell.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return xCell Returns the integer value of  xCell.
     */
    public int getXCell(){
        return xCell;
    }


    /**
     * Gets the y value of a cell.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return yCell Returns the integer value of yCell
     */
    public int getYCell(){
        return yCell;
    }


    /**
     * Returns the cellWidth.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return cellWidth Returns the double value of
     *                   cellWidth.
     */
    public double getCellWidth() {
        return cellWidth;
    }


    /**
     * Returns the cellHeight.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return cellHeight Returns the double value of
     *                    cellHeight
     */
    public double getCellHeight() {
        return cellHeight;
    }


    /**
     * Sets and computes the width of a single cell.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellsWide Number of cells in the game board's width
     */
    public void setCellWidth(int cellsWide){
        this.cellWidth = (double)gc.getCanvas().widthProperty().intValue()/cellsWide;
    }


    /**
     * Sets and computes the height of a single cell.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @param cellsHigh Number of cells in the game board's height
     */
    public void setCellHeight(int cellsHigh) {
        this.cellHeight = (double)gc.getCanvas().heightProperty().intValue()/cellsHigh;
    }
}