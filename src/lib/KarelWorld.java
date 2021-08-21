package lib;

import fopbot.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.LinkedList;

public class KarelWorld {
    private LinkedList<LinkedList<FieldEntity>> entityStates;
    private final int height;
    private final int width;
    private int delay = 100;
    private JFrame guiFrame;
    private GuiPanel guiPanel;
    private LinkedList<FieldEntity>[][] entities;

    public KarelWorld(int width, int height) {
        if (width >= 1 && height >= 1) {
            this.height = height;
            this.width = width;
            LinkedList<FieldEntity> lst = new LinkedList<>();
            this.entities = (LinkedList<FieldEntity>[][]) Array.newInstance(lst.getClass(), new int[]{width, height});
            for (int i = 0; i < width; i++)
                for (int j = 0; j < height; j++)
                    this.entities[i][j] = new LinkedList<>();
        }
        throw new RuntimeException("Invalid world size: " + width + " x " + height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDelay() {
        return delay;
    }

    public LinkedList<LinkedList<FieldEntity>> getEntityStates() {
        return entityStates;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    protected void checkXCoordinate(int x) {
        if (x > World.getWidth() - 1 || x < 0) {
            throw new RuntimeException("Invalid x-coordinate: " + x);
        }
    }

    protected void checkYCoordinate(int y) {
        if (y > World.getHeight() - 1 || y < 0) {
            throw new RuntimeException("Invalid y-coordinate: " + y);
        }
    }

    public LinkedList<FieldEntity> getFieldEntities(int x, int y) {
        return entities[x][y];
    }

    public LinkedList<FieldEntity> getAllFieldEntities() {
        var temp = new LinkedList<FieldEntity>();
        for (int i = 0; i < this.width; i++)
            for (var field : entities[i])
                if (field.size() > 0)
                    temp.addAll(field);
        return temp;
    }

    public boolean isBlockInField(int x, int y) {
        for (var entity : entities[x][y]) {
            if (entity instanceof Block)
                return true;
        }
        return false;
    }

    public void placeBlock(int x, int y) {
        checkXCoordinate(x);
        checkYCoordinate(y);
        if (getFieldEntities(x, y).stream().noneMatch(fieldEntity -> fieldEntity instanceof Block))
            entities[x][y].add(new Block(x, y));
        this.triggerUpdate();
    }

    protected void sleep() {
        try {
            Thread.sleep((long) this.delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void triggerUpdate() {
        //saveEntityState();
        updateGui();
    }

    protected void updateGui() {
        if (this.isVisible()) {
            this.guiPanel.updateGui();
        }
    }

    public void setVisible(boolean visible) {
        if (visible && this.guiFrame == null) {
            this.guiFrame = new JFrame("PlaneField");
            this.guiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            if (this.guiPanel == null) {
                this.guiPanel = new GuiPanel(this);

            }
        }
    }

    private void saveEntityState() {
        var allEntitysCopy = new LinkedList<FieldEntity>();
        if (entityStates == null) {
            entityStates = new LinkedList<>();
        }
        for (var entity : getAllFieldEntities()) {
            if (entity instanceof Block) {
                Block block = new Block(entity.getX(), entity.getY());
                allEntitysCopy.add(block);
            }
        }
    }

    public void reset() {
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                this.entities[i][j].clear();
            }
        }
        this.triggerUpdate();
    }

    public boolean isVisible() {
        return this.guiFrame != null && this.guiFrame.isVisible();
    }

    public GuiPanel getGuiPanel() {
        return this.guiPanel;
    }

    public void setGuiPanel(GuiPanel guiPanel) {
        this.guiPanel = guiPanel;
    }
}
